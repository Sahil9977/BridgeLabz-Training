package database;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class PatientDAO {
	
	public boolean insertPatient(Patient patient) {
		String sql = "INSERT INTO patients(name, DOB, contact, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, patient.getName());
			pstmt.setDate(2, Date.valueOf(patient.getDob()));
			pstmt.setString(3, patient.getContact());
			pstmt.setString(4,patient.getEmail());
			pstmt.setString(5, patient.getAddress());
			pstmt.setString(6, patient.getBloodGroup());
			
			int rows = pstmt.executeUpdate();
//			System.out.println(rowsAffected +"rows(s) inserted successfully");
			return rows>0;
			
		} catch(SQLException e ) {
//			System.out.println("Insert failed :"+e.getMessage());
			e.printStackTrace();
			return false;
		}
			
		
	}
	
	
	public List<Patient> getAllPatients() {
		String sql = "SELECT * FROM patients";
		
		List<Patient> patients = new ArrayList<>();
		
		
		try(Connection conn = DatabaseConnection.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)){
			
//			System.out.println("id\tName\tDOB\t\tContact\t\tEmail\t\tAddress\t\t\tBlood Group\t\n");
			while(rs.next()) {
				Patient p = null;
				int id = rs.getInt("patient_id");
				String name = rs.getString("name");
				Date date = rs.getDate("DOB");
				String contact = rs.getString("contact");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String bg = rs.getString("blood_group");
				
				p=new Patient(name, date.toLocalDate(), contact, email, address, bg);
				p.setId(id);
				patients.add(p);
				
//				System.out.println(id+"\t"+name+"\t"+date+"\t"+contact+"\t"+email+"\t"+address+"\t"+bg+"\n");
			}
			
			
		} catch(Exception e){
			System.out.println("fetch failed :"+e.getMessage());
			
		}
		return patients;
	}
	
	
	public Patient  getPatientById(int id) {
		
		String sql = "SELECT * FROM patients WHERE patient_id = ?";
		
		Patient patient = null;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
//				System.out.println("\nPatient found :\n");
//				System.out.println("ID : "+rs.getInt("patient_id"));
//				System.out.println("Name : "+rs.getString("name"));
//				System.out.println("DOB : "+rs.getDate("DOB"));
//				System.out.println("Contact : "+rs.getString("contact"));
//				System.out.println("Email : "+rs.getString("email"));
//				System.out.println("Address : "+rs.getString("address"));
//				System.out.println("Blood Group : "+rs.getString("blood_group"));
				
				patient = new Patient(rs.getString("name"), rs.getDate("DOB").toLocalDate(),
						rs.getString("contact"), rs.getString("email"), rs.getString("address"), rs.getString("blood_group"));
			}
//			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return patient;
	}
		
	
	public boolean updatePatientInfo(Map<String ,String> m , String [] arr ,int id) {
		
		String [] arr2 = new String[arr.length] ;
		
		for(int i=0;i<arr.length;i++) {
			arr2[i]=arr[i]+" = ?";
		}
		 
		String temp = String.join(",", arr2);
		
		String sql = "UPDATE patients SET "+temp+" WHERE patient_id = ?";
		System.out.println(sql);
		
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			int i=0;
			
			for( i=1;i<=arr.length;i++) {
//				System.out.println(arr[i-1]);
				if(m.containsKey(arr[i-1].trim())) {
//					System.out.println(m.get(arr[i-1].trim()));
					pst.setString(i,m.get(arr[i-1].trim()) );
				}
//				else System.out.println("Something went wrong !!");
			}
			
			pst.setInt(i, id);
			
			int rows = pst.executeUpdate();
//			System.out.println(rowsAffected+"rows updated");
			return rows>0;
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
	}
	
		
	
	public Patient getPatienthByContact(String contact) {
		
		String sql = "SELECT * FROM patients WHERE contact = ?";
		Patient patient = null;
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, contact);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
//				System.out.println("\nPatient found :\n");
//				System.out.println("ID : "+rs.getInt("patient_id"));
//				System.out.println("Name : "+rs.getString("name"));
//				System.out.println("DOB : "+rs.getDate("DOB"));
//				System.out.println("Contact : "+rs.getString("contact"));
//				System.out.println("Email : "+rs.getString("email"));
//				System.out.println("Address : "+rs.getString("address"));
//				System.out.println("Blood Group : "+rs.getString("blood_group"));
				
				patient = new Patient(rs.getString("name"), rs.getDate("DOB").toLocalDate(),
						rs.getString("contact"), rs.getString("email"), rs.getString("address"), rs.getString("blood_group"));
			}
//			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return patient;
		

	}
	
	
	public List<Patient> getPatientByName(String name) {
		
		String sql = "SELECT * FROM patients  name LIKE ?";
		
		List<Patient> patients = new ArrayList<Patient>();
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, "%"+name+"%");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				Patient patient = null;
//				System.out.println("\nPatient found :\n");
//				System.out.println("ID : "+rs.getInt("patient_id"));
//				System.out.println("Name : "+rs.getString("name"));
//				System.out.println("DOB : "+rs.getDate("DOB"));
//				System.out.println("Contact : "+rs.getString("contact"));
//				System.out.println("Email : "+rs.getString("email"));
//				System.out.println("Address : "+rs.getString("address"));
//				System.out.println("Blood Group : "+rs.getString("blood_group"));
				
				patient = new Patient(rs.getString("name"), rs.getDate("DOB").toLocalDate(),
						rs.getString("contact"), rs.getString("email"), rs.getString("address"), rs.getString("blood_group"));
				patients.add(patient);
			}
//			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return patients;

	}
	
	
	public void viewPatientHistory(int id){
		String sql = "SELECT d.doctor_name, a.appointment_date, v.diagnosis"
				+ " FROM visits v "
				+ "INNER JOIN appointments a "
				+ "ON v.appointment_id = a.appointment_id "
				+ "INNER JOIN doctors d "
				+ "ON a.doctor_id = d.doctor_id"
				+ " WHERE a.patient_id = ? "
				+ "ORDER BY a.appointment_date ASC";
		
	    try (Connection con = DatabaseConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql)) {

	           ps.setInt(1, id);

	           ResultSet rs = ps.executeQuery();

	           while (rs.next()) {
	               System.out.println("Doctor: " + rs.getString("doctor_name"));
	               System.out.println("Date: " + rs.getDate("appointment_date"));
	               System.out.println("Diagnosis: " + rs.getString("diagnosis"));
	               System.out.println("--------------------------");
	           }

	       } catch (Exception e) {
	           e.printStackTrace();
	       }
		
		
	}
	
	
	
	

}
