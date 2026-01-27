package address_book;

import java.util.*;

public class AddressBook {
	
	public  static void addNewContact(Scanner sc , List<Contact> addressBook) {
		
		
		System.out.println("Enter the first name of person :\n");
		String fName = sc.nextLine();
		
		System.out.println("Enter the last name of person :\n");
		String lName = sc.nextLine();
		
		System.out.println("Enter the address of person :\n");
		String address = sc.nextLine();
		
		System.out.println("Enter the city of person :\n");
		String city = sc.nextLine();
		
		System.out.println("Enter the state of person :\n");
		String state = sc.nextLine();
		
		System.out.println("Enter the zip code of person :\n");
		int zip = sc.nextInt();
		
		System.out.println("Enter the phone number of person :\n");
		int phoneNumber = sc.nextInt();
		
		System.out.println("Enter the email of person :\n");
		String email = sc.nextLine();
		
		addressBook.add(new Contact(fName, lName, address, city, state, zip, phoneNumber, email ));
	}
	

	
	
	
	

}
