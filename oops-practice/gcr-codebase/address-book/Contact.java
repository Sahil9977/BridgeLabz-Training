package address_book;

public class Contact {
	String firstName ;
	String lastName;
	String address;
	String city;
	String state;
	int zipCode ; 
	int phoneNumber;
	String email;
	
	public Contact(String firstName ,String lastName ,String address,String city,String state,int zipCode ,int phoneNumber ,String email) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipCode=zipCode;
		this.phoneNumber=phoneNumber;
		this.email=email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) return true;
		if(obj==null || getClass()!=obj.getClass()) return false;
		
		Contact contact = (Contact) obj;
		
		return this.firstName.toLowerCase().equalsIgnoreCase(contact.firstName.toLowerCase());
	}
	
	@Override
	public int hashCode() {
		return firstName.toLowerCase().hashCode();
	}
	
	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ "]";
	}

}
