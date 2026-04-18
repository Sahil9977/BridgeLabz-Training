package database;

import java.time.*;

public class Patient {
	
	private String name ;
	private LocalDate dob;
	private String contact;
	private String email;
	private String address;
	private String bloodGroup;
	private int id ;
	public Patient(String name, LocalDate dob, String contact, String email, String address, String bloodGroup) {
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.address = address;
		this.bloodGroup = bloodGroup;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	

	@Override
	public String toString() {
		return "Name = "+name+" DOB = "+dob+" Contact = "+contact+" Email = "+email+" Address = "+address+" Blood Group = "+bloodGroup;
	}

}
