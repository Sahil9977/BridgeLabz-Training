package address_book;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		List<Contact> addressBook = new ArrayList();
		
		
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println(
					"1) Add new person details (Type \"1\")\n"
					+"2) Edit person details (Type \"2\")\n"
					+"3) Search person details (Type \"3\")\n"
					+"4) Delete person details (Type \"4\")\n"
					+"5) Quit the process (Type \"5\")\n"
					);
			int choice = sc.nextInt();
			if(choice==5)break;
			sc.nextLine();
			
			switch (choice) {
			
			case 1:
				AddressBook.addNewContact(sc , addressBook); 
				break;
			
			
			}
			
			
			
			
		}while(true);
		
		

	}

}
