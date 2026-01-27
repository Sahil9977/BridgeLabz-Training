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
	

}
