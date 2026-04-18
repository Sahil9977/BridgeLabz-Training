package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.*;

public class AppointmentDAO {

	public boolean addAppointment(int dId, int pId, LocalDate date, LocalTime time) throws Exception {

		// First check availability
		boolean available = checkDoctorAvailability(dId, Date.valueOf(date), Time.valueOf(time));

		if (!available) {
			System.out.println("❌ Slot is FULL. Cannot book appointment.");
			return false;
		}

		// If available proceed booking
		String insertSql = "INSERT INTO appointments "
				+ "(patient_id, doctor_id, appointment_date, appointment_time, status) "
				+ "VALUES (?, ?, ?, ?, 'SCHEDULED')";

		try (Connection con = DatabaseConnection.getConnection();
				PreparedStatement insertStmt = con.prepareStatement(insertSql)) {

			insertStmt.setInt(1, pId);
			insertStmt.setInt(2, dId);
			insertStmt.setDate(3, Date.valueOf(date));
			insertStmt.setTime(4, Time.valueOf(time));

			int row = insertStmt.executeUpdate();
			return row > 0;
		}
	}

	public boolean checkDoctorAvailability(int doctorId, Date date, Time time) throws Exception {

		boolean slotAvailable = true;

		String sql = "SELECT appointment_time, COUNT(*) AS total " + "FROM appointments " + "WHERE doctor_id=? "
				+ "AND appointment_date=? " + "AND status='SCHEDULED' " + "GROUP BY appointment_time "
				+ "ORDER BY appointment_time";

		try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, doctorId);
			ps.setDate(2, date);

			ResultSet rs = ps.executeQuery();

			System.out.println("Slot Status for Doctor " + doctorId + " on " + date);

			while (rs.next()) {

				Time slotTime = rs.getTime("appointment_time");
				int total = rs.getInt("total");

				if (total >= 10) {
					System.out.println("Time: " + slotTime + " | Booked: " + total + " | FULL");
				} else {
					System.out.println("Time: " + slotTime + " | Booked: " + total + " | Available");
				}

				// check requested slot
				if (slotTime.equals(time) && total >= 10) {
					slotAvailable = false;
				}
			}
		}

		return slotAvailable;
	}

	public static void cancelAppointment(int appointmentId) throws Exception {

		Connection con = DatabaseConnection.getConnection();
		con.setAutoCommit(false);

		try {

			String updateSql = "UPDATE appointments SET status='CANCELLED' " + "WHERE appointment_id=?";

			PreparedStatement ps1 = con.prepareStatement(updateSql);
			ps1.setInt(1, appointmentId);
			ps1.executeUpdate();

			String auditSql = "INSERT INTO appointment_audit " + "(appointment_id, action) VALUES (?, 'CANCELLED')";

			PreparedStatement ps2 = con.prepareStatement(auditSql);
			ps2.setInt(1, appointmentId);
			ps2.executeUpdate();

			con.commit();
			System.out.println("Appointment Cancelled!");

		} catch (Exception e) {
			con.rollback();
			System.out.println("Error! Rolled Back.");
		}

	}

	public  void rescheduleAppointment(int appointmentId, int doctorId, Date newDate, Time newTime)
			throws Exception {

		Connection con = DatabaseConnection.getConnection();
		con.setAutoCommit(false);

		try {

//  Check availability 
			boolean available = checkDoctorAvailability(doctorId, newDate, newTime);

			if (!available) {
				System.out.println("Slot Full! Cannot Reschedule.");
				con.rollback();
				return;
			}

// Update appointment
			String updateSql = "UPDATE appointments SET " + "doctor_id=?, appointment_date=?, appointment_time=? "
					+ "WHERE appointment_id=?";

			PreparedStatement ps = con.prepareStatement(updateSql);
			ps.setInt(1, doctorId);
			ps.setDate(2, newDate);
			ps.setTime(3, newTime);
			ps.setInt(4, appointmentId);

			ps.executeUpdate();

// Insert into appointment_audit table
			String auditSql = "INSERT INTO appointment_audit " + "(appointment_id, action, action_time) "
					+ "VALUES (?, 'RESCHEDULED', NOW())";

			PreparedStatement auditStmt = con.prepareStatement(auditSql);
			auditStmt.setInt(1, appointmentId);
			auditStmt.executeUpdate();

// Commit transaction
			con.commit();

			System.out.println("Rescheduled Successfully & Audit Logged!");

		} catch (Exception e) {
			con.rollback();
			System.out.println("Error Occurred! Transaction Rolled Back.");
			throw e;
		} 
	}
	
	
	public static void viewDailySchedule(Date date) throws Exception {

	    Connection con = DatabaseConnection.getConnection();

	    String sql = "SELECT a.appointment_time, p.name as patient, "
	            + "d.name as doctor, a.status "
	            + "FROM appointments a "
	            + "JOIN patients p ON a.patient_id=p.patient_id "
	            + "JOIN doctors d ON a.doctor_id=d.doctor_id "
	            + "WHERE a.appointment_date=? "
	            + "ORDER BY a.appointment_time";

	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setDate(1, date);

	    ResultSet rs = ps.executeQuery();

	    while (rs.next()) {
	        System.out.println(rs.getTime("appointment_time")
	                + " | Patient: " + rs.getString("patient")
	                + " | Doctor: " + rs.getString("doctor")
	                + " | Status: " + rs.getString("status"));
	    }

	}

}
