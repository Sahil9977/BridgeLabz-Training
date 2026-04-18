package address_book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.Map.*;
import java.util.stream.*;

public class Main {

	public static void main(String[] args) {
		

		
		HashMap<String , AddressBook> addressBookMap = new HashMap<String, AddressBook>();
		HashMap<String, List<Contact>> cityMap = new HashMap<String, List<Contact>>();
		HashMap<String, List<Contact>> stateMap = new HashMap<String, List<Contact>>();
		
		Scanner sc = new Scanner(System.in);
	
		do {
			System.out.println(
					"\n1) Add new Address Book  (Type \"1\")\n"
					+"2) Add new Person details in Adress Book (Type \"2\")\n"
					+"3) Edit Person details (Type \"3\")\n"
					+"4) Search Person by City or State (Type \"4\")\n"
					+"5) Show all Person that have same City and State (Type \"5\")\n"
					+"6) Delete Person details (Type \"6\")\n"
					+"7) Sort Person By Name (Type \"7\")\n"
					+"8) Sort Person By City (Type \"8\")\n"
					+"9) Sort Person By ZipCode (Type \"9\")\n"
					+"10) Read Person data by using FILE IO (Type \"10\")\n"
					+"11) Write Person data by using FILE IO (Type \"11\")\n"
					+"12) Read Person data by using CSV file (Type \"12\")\n"
					+"13) Write Person data by using CSV file (Type \"13\")\n"
					+"14) Read Person data by using JSON file (Type \"14\")\n"
					+"15) Write Person data by using JSON file (Type \"15\")\n"
					+"16) Quit the process (Type \"16\")\n"
					);
			int choice = sc.nextInt();
			if(choice==16)break;
			sc.nextLine();
			
			switch (choice) {
			
			case 1:
				
				System.out.println("\nEnter the name of Address Book : ");
				String name = sc.nextLine();
				
				if(!addressBookMap.containsKey(name))addressBookMap.put(name,new AddressBook());
				else System.out.println("Address Book already exists!");
				
				break;
			
			case 2:
				
				System.out.println("Enter the Address Book name : ");
				String book1= sc.nextLine();
				
				if(addressBookMap.containsKey(book1)) {
					if(addressBookMap.get(book1).addNewContact(sc))System.out.println("Person is successfully added to "+book1+" address book.");
					else System.out.println("Something went wrong, Please try again !");
				}
				else System.out.println("Adress Book is not exist.");
			
				break;
				
			case 3 : 

				System.out.println("Enter the Address Book name : ");
				String book2 = sc.nextLine();
				
				if(addressBookMap.containsKey(book2)) {
					if(addressBookMap.get(book2).editContact(sc)) System.out.println("Person is successfully edited.");
					else System.out.println("Something went wrong, Please try again !");
				}
				else System.out.println("Adress Book is not exist.");
				break;
				
			case 4 :
				
				System.out.println("Enter the City or State :");
				String s = sc.nextLine();
				
				
//-------------------------------------Normal Loop========================================================================
//				for(Entry<String , AddressBook> entry : addressBookMap.entrySet()) {
//					List<Contact> list = entry.getValue().addressBook;
//					List<Contact> cityList = new ArrayList<Contact>();
//					List<Contact> stateList = new ArrayList<Contact>();
//					
//					for(int i=0;i<list.size();i++) {
//						if(list.get(i).getCity().equalsIgnoreCase(s)) {
//							if(cityMap.containsKey(s))cityMap.get(s).add(list.get(i));
//							else {
//								cityList.add(list.get(i));
//								cityMap.put(s, cityList);
//							}
//						}
//						else if(list.get(i).getState().equalsIgnoreCase(s)) {
//							if(stateMap.containsKey(s))stateMap.get(s).add(list.get(i));
//							else {
//								stateList.add(list.get(i));
//								stateMap.put(s, stateList);
//							}
//						}
//						else System.out.println("Entered City or State is not in any Address Book.");
//						
//					}
//					
//					
//				}
//				
//				System.out.println("Contacts thave have same city : "+cityMap.get(s).size());
//				for(int i=0;i<cityMap.get(s).size();i++)System.out.println(cityMap.get(s).get(i));
//				
//				System.out.println("\nContacts thave have same state : "+stateMap.get(s).size());
//				for(int i=0;i<stateMap.get(s).size();i++)System.out.println(stateMap.get(s).get(i));
				

//				
//------------------we use this also=================================================================================================> 
				// in this we have multiple keys with different city and state store person
				
//				Map<String, List<Contact>> cityMap =
//			    addressBookMap.values().stream()
//			        .flatMap(book -> book.addressBook.stream())
//			        .collect(Collectors.groupingBy(Contact::getCity));
//
//				Map<String, List<Contact>> stateMap =
//			    addressBookMap.values().stream()
//			        .flatMap(book -> book.addressBook.stream())
//			        .collect(Collectors.groupingBy(Contact::getState));
//				
				
//------------------Comparison between normal vs function ====================================================================>
				
//				cityMap.computeIfAbsent(city, k -> new ArrayList<>()).add(contact);
//	 or
//				if(cityMap.containsKey(city))
//				    cityMap.get(city).add(contact);
//				else
//				    cityMap.put(city, new ArrayList<>(List.of(contact)));

				addressBookMap.values().stream()
					.flatMap(contact -> contact.addressBook.stream())
//					.filter(c -> c.getCity().equalsIgnoreCase(s))
					.forEach(k ->{
						cityMap.computeIfAbsent(k.getCity(), key -> new ArrayList<Contact>())
						.add(k);
					});
				
						
				addressBookMap.values().stream()
					.flatMap(contact -> contact.addressBook.stream())
//					.filter(c -> c.getState().equalsIgnoreCase(s))
					.forEach(k ->{
						stateMap.computeIfAbsent(k.getState(), key -> new ArrayList<Contact>())
						.add(k);
					});
				
//				cityMap.entrySet().stream().forEach(v->{
//					System.out.print(v.getKey()+"-->");
//					v.getValue().stream()
//						.forEach(c -> System.out.println(c));
//				});
						

				// uc 8
				
				cityMap.entrySet().stream()
				.filter(c->c.getKey().equalsIgnoreCase(s))
				.forEach(v->{
					System.out.println("\nPerson with have same "+s+" : ");
					System.out.println(v.getKey()+"-->");
					v.getValue().stream()
						.forEach(c -> System.out.println(c));
				});
				

				stateMap.entrySet().stream()
				.filter(c->c.getKey().equalsIgnoreCase(s))
				.forEach(v->{
					System.out.println("\nPerson with have same "+s+" : ");
					System.out.println(v.getKey()+"-->");
					v.getValue().stream()
						.forEach(c -> System.out.println(c));
				});
				
				
				break;
				
			case 5 :
				
				//uc 9
				System.out.println("\nPerson with have same city : ");
				
				cityMap.entrySet().stream()
				.forEach(v->{
					System.out.print(v.getKey()+"-->");
					v.getValue().stream()
						.forEach(c -> System.out.println(c));
				});
				
				
				System.out.println("\nPerson with have same state : ");
	
				stateMap.entrySet().stream()
				.forEach(v->{
					System.out.print(v.getKey()+"-->");
					v.getValue().stream()
						.forEach(c -> System.out.println(c));
				});
				
				System.out.println("\nCount person that have same city :");
				cityMap.entrySet().stream()
				.collect(Collectors.groupingBy(k-> k.getKey() , Collectors.counting()))
				.forEach((k,v)->{
					System.out.println(k+" --> "+v);
				});
			
				System.out.println("\nCount person that have same state :");
				stateMap.entrySet().stream()
				.collect(Collectors.groupingBy(k-> k.getKey() , Collectors.counting()))
				.forEach((k,v)->{
					System.out.println(k+" --> "+v);
				});

				break;
				
				
			case 6 :
				
				System.out.println("Enter the Address Book name : ");
				String book3 = sc.nextLine();
				
				if(addressBookMap.containsKey(book3)) {
					if(addressBookMap.get(book3).editContact(sc)) System.out.println("Person is successfully deleted.");
					else System.out.println("Something went wrong, Please try again !");
				}
				else System.out.println("Adress Book is not exist.");
				break;
			
			case 7 :
				
				
				break;
				
			case 8 :
				break ;
				
			case 9 :
				break;
				
//				
//			case 10 :
//				
////				System.out.println("Enter the address");
//				String path = "";
//				try(BufferedReader br = new BufferedReader(new FileReader(path))) {
//					String line =br.readLine();
//
//					
//					while(line!=null) {3q3
//						line =br.readLine();
//						String [] arr = line.split(",");
//						System.err.println(arr[0]);
//					}
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				break ;
				
			case 11 :
				
				System.out.println("Enter the name of Address Book :");
				String bName = sc.nextLine();
				
				List<AddressBook> found = addressBookMap.entrySet().stream()
						.filter(k -> k.getKey().equalsIgnoreCase(bName))
						.map(m->m.getValue())
						.toList();
										
						
						
				break;
				
			}
			

				

			


				
			
		}while(true);
		
		

	}

}
