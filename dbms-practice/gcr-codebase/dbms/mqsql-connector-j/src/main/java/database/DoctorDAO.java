package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DoctorDAO {
	
	public boolean insertDoctor(Doctor doctor) {
		
		String sql = "INSERT INTO doctors(doctor_name , contact , specialty_id , consultant_fee)"
				+ " VALUES (? , ? , ?,?)";
		
		try(Connection conn = DatabaseConnection.getConnection() ;
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, doctor.getName());
			pst.setString(2, doctor.getContact());
			pst.setInt(3, doctor.getSpecialtyId());
			pst.setInt(4, doctor.getFee());
			
			return true;
			
		} catch(Exception e ) {
			e.printStackTrace();
			return false;
		}
	}
	

	
	public boolean updateDoctorSpecialty(int dId , int sId) {
		
		String sql = "UPDATE doctors SET specialty_id = ? WHERE doctor_id = ?";
		
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, sId);
			pst.setInt(2, dId);
			
			int rows = pst.executeUpdate();
			
			return rows>0;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void searchDoctorBySpecialty(String s ) {
		String sql ="select * from doctors "
				+ "inner join specialties"
				+ "on doctors.specialty_id = specialties.specialty_id"
				+ "where specialty_name = ?"
				+ "and is_active = true";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setString(1, s);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("doctor_name");
				String contact = rs.getString("contact");
				int fee = rs.getInt("consultant_fee");
				String specialty = rs.getString("specialty_name");
				
				System.out.println(name+" - "+contact+" - "+specialty+" - "+fee);
			}
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	public boolean deactivateDoctorProfile(int id) {

		// here sleect 1 is mean check any appointment found return 1
	    String checkSql = "SELECT 1 FROM appointments "
	    		+ "WHERE doctor_id = ?"
	    		+ "AND appointment_date >= CURDATE()"
	    		+ "LIMIT 1";

	    String updateSql = "UPDATE doctors SET is_active = FALSE WHERE doctor_id = ?";

	    try (Connection conn = DatabaseConnection.getConnection()) {

	        // Check future appointments
	        try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
	            checkStmt.setInt(1, id);
	            ResultSet rs = checkStmt.executeQuery();

	            if (rs.next()) {
	                System.out.println("Cannot deactivate. Future appointments exist.");
	                return false;
	            }
	        }

	        // Step 2: Soft delete
	        try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
	        	
	            updateStmt.setInt(1, id);

	            int rowsUpdated = updateStmt.executeUpdate();
	            return rowsUpdated > 0;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
}
