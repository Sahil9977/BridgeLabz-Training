package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SpecialtyDAO {

	public boolean addSpecialty(Specialty specialty) {
		
		String sql = "INSERT INTO specialties(specialty_name) VALUES (?)";
		
		try(Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, specialty.getName());
			return true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void viewSpecialties() {
		
		
		String sql = "select * from specialties";
		
		try(Connection conn = DatabaseConnection.getConnection()) {
			
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("specialty_id");
				String name = rs.getString("specialty_name");
				System.out.println(id+" - "+name);
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
