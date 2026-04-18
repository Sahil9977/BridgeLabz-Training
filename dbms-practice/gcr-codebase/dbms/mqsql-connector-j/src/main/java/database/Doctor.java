package database;

public class Doctor {
	
	String name ; 
	String contact;
	int specialtyId;
	int fee;
	boolean isActive = true;
	
	public Doctor(String name, String contact, int specialtyId, int fee) {
		super();
		this.name = name;
		this.contact = contact;
		this.specialtyId = specialtyId;
		this.fee = fee;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(int specialtyId) {
		this.specialtyId = specialtyId;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", contact=" + contact + ", specialtyId=" + specialtyId + ", fee=" + fee
				+ ", isActive=" + isActive + "]";
	}

}
