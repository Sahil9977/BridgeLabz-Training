package address_book;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
	
	List<Contact> addressBook = new ArrayList<>();
	
	public boolean addNewContact(Scanner sc ) {
		
		
		System.out.println("\nEnter the first name of person :\n");
		String fName = sc.nextLine();
		
//		for(int i=0;i<addressBook.size();i++) {
//			if(addressBook.get(i).getFirstName().equalsIgnoreCase(fName)) {
//				System.out.println("Duplicate name found");
//				return false;
//			};
//		}
		
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
		sc.nextLine();
		
		System.out.println("Enter the phone number of person :\n");
		int phoneNumber = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the email of person :\n");
		String email = sc.nextLine();
		
		if(addressBook.contains(new Contact(fName, lName, address, city, state, zip, phoneNumber, email ))) {
			System.out.println("\nDuplicate found.");
			return false;
		}
		
		// why we dont direct use .equals
		// because .contains internally use .equals || we can use .equals directly but for that we make a loop then we have to .equals like that
//		for(Contact p : list) {
//		    if(p.equals(newPerson)) {
//		        // duplicate
//		    }
//		}

		
		//implementation on .contains
//		ArrayList<Person> list = new ArrayList<>();
//		list.contains(new Person("Aman"));
//		for(Person p : list) {
//		    if(p.equals(newPerson)) {
//		        return true;
//		    }
//		}

		else return addressBook.add(new Contact(fName, lName, address, city, state, zip, phoneNumber, email ));
	}
	
	public boolean editContact(Scanner sc ) {
		
		System.out.println("Enter the name of person you want to edit :/n");
		String fName = sc.nextLine();
		

		if(addressBook.size()==0) return false;
		else {
			for(int i=0;i<addressBook.size();i++) {
				if(addressBook.get(i).getFirstName().equalsIgnoreCase(fName)) {
					System.out.println("Enter updated first name :/n");
					String updatedFName = sc.nextLine();
					
					if(addressBook.get(i).getFirstName().equalsIgnoreCase(fName)) {
						System.out.println("Duplicate name found");
						return false;
					};
					
					System.out.println("Enter updated last name :/n");
					String updatedLName = sc.nextLine();
					
					System.out.println("Enter updated address :/n");
					String updatedAddress = sc.nextLine();
					
					System.out.println("Enter updated city :/n");
					String updatedCity = sc.nextLine();
					
					System.out.println("Enter updated state :/n");
					String updatedState = sc.nextLine();
					
					System.out.println("Enter updated zip code :/n");
					int updatedZipCode = sc.nextInt();
					
					System.out.println("Enter updated phone number :/n");
					int updatedPhoneNumber= sc.nextInt();
					
					System.out.println("Enter updated email :/n");
					String updatedEmail = sc.nextLine();
					
				
					addressBook.get(i).setFirstName(updatedFName) ;
					addressBook.get(i).setLastName ( updatedLName);
					addressBook.get(i).setAddress(updatedAddress);
					addressBook.get(i).setCity(updatedCity);
					addressBook.get(i).setState(updatedState);
					addressBook.get(i).setZipCode(updatedZipCode);
					addressBook.get(i).setPhoneNumber(updatedPhoneNumber);
					addressBook.get(i).setEmail(updatedEmail);
					return true;
				}
				
			}
			return false;
		}

	}
	
	public Contact searchContactByCityOrState( ) {
		 return null;
	}
	
	public boolean deleteContact(Scanner sc ) {
		
		System.out.println("Enter the Name of person you want to delete : ");
		String fName = sc.nextLine();
		
		if(addressBook.size()<=0)return false;
		else {
			for(int i=0;i<addressBook.size() ;i++) {
				if(addressBook.get(i).getFirstName().equalsIgnoreCase(fName)) {
					 addressBook.remove(i);
					 return true;
				}
				
			}
			return false;
		}
	}
	
	
	public List<Contact> sortByName(){
		return addressBook.stream()
				// comparing((Contact (this is the type c (varible) -> c.getFirstName()(name) , String.CASE_INSENSITIVE_ORDER))
				.sorted(Comparator.comparing((Contact c)->c.getFirstName(),String.CASE_INSENSITIVE_ORDER)
						.thenComparing(Contact::getLastName, String.CASE_INSENSITIVE_ORDER))
				.toList();
	}
	
	
	public List<Contact> sortByCity(){
		return addressBook.stream()
				// comparing((Contact (this is the type c (varible) -> c.getFirstName()(name) , String.CASE_INSENSITIVE_ORDER))
				.sorted(Comparator.comparing((Contact c)->c.getCity(),String.CASE_INSENSITIVE_ORDER))
				.toList();
	}
	
	public List<Contact> sortByState(){
		return addressBook.stream()
				// comparing((Contact (this is the type c (varible) -> c.getFirstName()(name) , String.CASE_INSENSITIVE_ORDER))
				.sorted(Comparator.comparing((Contact c)->c.getState(),String.CASE_INSENSITIVE_ORDER))
				.toList();
	}
	
	public List<Contact> sortByZip(){
		return addressBook.stream()
				// comparing((Contact (this is the type c (varible) -> c.getFirstName()(name) , String.CASE_INSENSITIVE_ORDER))
				.sorted(Comparator.comparingInt(Contact::getZipCode))
				.toList();
	}
	
	
}
