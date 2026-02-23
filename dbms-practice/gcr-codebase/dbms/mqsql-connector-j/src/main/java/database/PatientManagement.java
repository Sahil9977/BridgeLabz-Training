package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

public class PatientManagement {
	
	private static PatientDAO patientDAO = new PatientDAO();
	private static 	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		

//		List<Patient> patients = new ArrayList<Patient>();
	

        
        while(true) {
            System.out.println("\n===== Patient Management System =====");
            System.out.println("1. Add New Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. View Patient by ID");
            System.out.println("4. View Patient by Contact");
            System.out.println("5. View Patient by Name");
            System.out.println("6. Update Patient");
//            System.out.println("5. Delete Student");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice==7)break;
            switch (choice) {
			case 1:
				
				Patient patient = null;
				System.out.println("Enter the pateint name :\n");
				String name =sc.nextLine();
				
				System.out.println("Enter the pateint DOB(yyyy-mm-dd) :\n");
				String dob = sc.nextLine();
				
				System.out.println("Enter the pateint contact number :\n");
				String contact = sc.nextLine();
				
				System.out.println("Enter the pateint email :\n");
				String email = sc.nextLine();
				
				System.out.println("Enter the pateint address :\n");
				String address = sc.nextLine();
				
				System.out.println("Enter the pateint blood group :\n");
				String bloodGroup = sc.nextLine();
				
				patient = new Patient(name, LocalDate.parse(dob), contact, email, address, bloodGroup);
				if(patientDAO.insertPatient(patient))System.out.println("Patient registered successfully!");
				
				break;

			case 2:
				List<Patient> patients = patientDAO.getAllPatients();
				System.out.println("id\tName\tDOB\t\tContact\t\tEmail\t\tAddress\t\t\tBlood Group\t\n");
				for(Patient p : patients) {
					System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getDob()+"\t"+p.getContact()+"\t"+p.getEmail()
					+"\t"+p.getAddress()+"\t"+p.getBloodGroup()+"\n");
				}
				break;
			
			case 3:
//				viewPatientById();
				System.out.println("Enter the Patient ID :");
				int id = sc.nextInt();
				Patient p = patientDAO.getPatientById(id);
				
				if(p!=null) {
					System.out.println("\nPatient found :\n");
					System.out.println("ID : "+p.getId());
					System.out.println("Name : "+p.getName());
					System.out.println("DOB : "+p.getDob());
					System.out.println("Contact : "+p.getContact());
					System.out.println("Email : "+p.getEmail());
					System.out.println("Address : "+p.getAddress());
					System.out.println("Blood Group : "+p.getBloodGroup());
				} else System.out.println("Patient not found!");
				
				break;
			
			case 4:
				System.out.println("Enter the Patient Contact :");
				String cont = sc.nextLine();
				Patient p1 = patientDAO.getPatienthByContact(cont);
				
				if(p1!=null) {
					System.out.println("\nPatient found :\n");
					System.out.println("ID : "+p1.getId());
					System.out.println("Name : "+p1.getName());
					System.out.println("DOB : "+p1.getDob());
					System.out.println("Contact : "+p1.getContact());
					System.out.println("Email : "+p1.getEmail());
					System.out.println("Address : "+p1.getAddress());
					System.out.println("Blood Group : "+p1.getBloodGroup());
				} else System.out.println("Patient not found!");
				break;
			
			case 5:
				
				System.out.println("Enter the Patient Name :");
				String nam = sc.nextLine();
				List<Patient> patientss = patientDAO.getPatientByName(nam);
				if(patientss.size()<=0)System.out.println("No patient found with this name");
				else {
					System.out.println("id\tName\tDOB\t\tContact\t\tEmail\t\tAddress\t\t\tBlood Group\t\n");
					for(Patient p2 : patientss) {
						System.out.println(p2.getId()+"\t"+p2.getName()+"\t"+p2.getDob()+"\t"+p2.getContact()+"\t"+p2.getEmail()
						+"\t"+p2.getAddress()+"\t"+p2.getBloodGroup()+"\n");
					}
				}
				
				break;
			
			case 6:
//				updatePatient();
				System.out.println("Enter the ID of the Patient you want to modify :");
				int idx = sc.nextInt();
				Patient p3 = patientDAO.getPatientById(idx);
				
				if(p3!=null) {
					System.out.println("\nPatient found :\n");
					System.out.println("ID : "+p3.getId());
					System.out.println("Name : "+p3.getName());
					System.out.println("DOB : "+p3.getDob());
					System.out.println("Contact : "+p3.getContact());
					System.out.println("Email : "+p3.getEmail());
					System.out.println("Address : "+p3.getAddress());
					System.out.println("Blood Group : "+p3.getBloodGroup());
				} else System.out.println("Patient not found!");
				
				//udpate data 
				System.out.println("\n\nWhat feilds want to update in this patient"
						+ " (\"contact , email , address , blood_group\")?\n"
						+ "\t\t\t(NOTE - enter the feilds with comma sepearated)"
						);
				String s = sc.nextLine();
				String [] arr =s.split(",");
				
				Map<String , String> m = new HashMap<String, String>();
				m.put("contact", "");
				m.put("email", "");
				m.put("address", "");
				m.put("blood_group", "");
				
				for(int i=0;i<arr.length;i++) {
					String key = arr[i].trim();
					if(m.containsKey(key)) {
						System.out.println("Enter the updated "+key+" :");
						String ne = sc.nextLine();
						m.put(key, ne);
					}
//					for(Entry<String, String> k: m.entrySet()) {
//						if(k.getKey().equals(key)) {
//							System.out.println("Enter the updated "+key+":\n");
//							String ne = sc.nextLine();
//							m.put(key, ne );
//							break;
//						}
//					}
				}
				
				patientDAO.updatePatientInfo(m, arr, idx) ;
				
				break;
	
			}
        }
		
		
	

		
		System.out.println("-----Search Patient-----"
				+ "\n1. Search by ID"
				+ "\n2.Search by Contact"
				+ "\n3 Search by Name");
		
		System.out.println("\nEnter your choice :\n");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch (choice) {
		case 1:
			System.out.println("Enter the Patient ID :");
			int pid = sc.nextInt();
			searchById(pid);
			break;
			
		case 2:
			System.out.println("Enter the Patient ID :");
			String contact = sc.nextLine();
			searchByContact(contact);
			break;
			
		case 3:
			System.out.println("Enter the Patient ID :");
			String name = sc.nextLine();
			searchByName(name);

		default:
			break;
		}
		
		
	}
	



	


//
//	public static void addPatient(String name ,LocalDate dob , String contact
//			, String email , String address, String bloodGroup) {
//		String sql = "INSERT INTO patients(name, DOB, contact, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?)";
//		
//		try(Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)){
//			
//			pstmt.setString(1, name);
//			pstmt.setDate(2, Date.valueOf(dob));
//			pstmt.setString(3, contact);
//			pstmt.setString(4,email);
//			pstmt.setString(5, address);
//			pstmt.setString(6, bloodGroup);
//			
//			int rowsAffected = pstmt.executeUpdate();
//			System.out.println(rowsAffected +"rows(s) inserted successfully");
//			
//		} catch(SQLException e ) {
//			System.out.println("Insert failed :"+e.getMessage());
//		}
//			
//		
//	}
	
//	
//	public static void getAllPatients() {
//		String sql = "SELECT * FROM patients";
//		
//		try(Connection conn = DatabaseConnection.getConnection();
//				Statement st = conn.createStatement();
//				ResultSet rs = st.executeQuery(sql)){
//			
//			System.out.println("id\tName\tDOB\t\tContact\t\tEmail\t\tAddress\t\t\tBlood Group\t\n");
//			while(rs.next()) {
//				int id = rs.getInt("patient_id");
//				String name = rs.getString("name");
//				Date date = rs.getDate("DOB");
//				String contact = rs.getString("contact");
//				String email = rs.getString("email");
//				String address = rs.getString("address");
//				String bg = rs.getString("blood_group");
//				
//				System.out.println(id+"\t"+name+"\t"+date+"\t"+contact+"\t"+email+"\t"+address+"\t"+bg+"\n");
//			}
//			
//		} catch(Exception e){
//			System.out.println("fetch failed :"+e.getMessage());
//			
//		}
//	}
//	
	
	public static void searchById(int id) {
		String sql = "SELECT * FROM patients WHERE patient_id = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("\nPatient found :\n");
				System.out.println("ID : "+rs.getInt("patient_id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("DOB : "+rs.getDate("DOB"));
				System.out.println("Contact : "+rs.getString("contact"));
				System.out.println("Email : "+rs.getString("email"));
				System.out.println("Address : "+rs.getString("address"));
				System.out.println("Blood Group : "+rs.getString("blood_group"));
			}
			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	
	public static void updatePatientInfo(Map<String ,String> m , String [] arr ,int id) {
		
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
				else System.out.println("Something went wrong !!");
			}
			
			pst.setInt(i, id);
			
			int rowsAffected = pst.executeUpdate();
			System.out.println(rowsAffected+"rows updated");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
		
	
	public static void searchByContact(String contact) {
		
		String sql = "SELECT * FROM patients WHERE contact = ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, contact);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("\nPatient found :\n");
				System.out.println("ID : "+rs.getInt("patient_id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("DOB : "+rs.getDate("DOB"));
				System.out.println("Contact : "+rs.getString("contact"));
				System.out.println("Email : "+rs.getString("email"));
				System.out.println("Address : "+rs.getString("address"));
				System.out.println("Blood Group : "+rs.getString("blood_group"));
			}
			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	
	
	private static void searchByName(String name) {
		
		String sql = "SELECT * FROM patients  name LIKE ?";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, "%"+name+"%");
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				System.out.println("\nPatient found :\n");
				System.out.println("ID : "+rs.getInt("patient_id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("DOB : "+rs.getDate("DOB"));
				System.out.println("Contact : "+rs.getString("contact"));
				System.out.println("Email : "+rs.getString("email"));
				System.out.println("Address : "+rs.getString("address"));
				System.out.println("Blood Group : "+rs.getString("blood_group"));
			}
			else System.out.println("Patient not found!");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	


}
