package class_and_object;
import java.util.Scanner;
class Item{
	int itemCode;
	String itemName;
	double price;
	
	Item(int Code,String Name,double Cost){
		itemCode = Code;
        itemName = Name;
        price =Cost;
	}
	
	void displayDetails() {
		System.out.println("ItemCode:"+itemCode);
		System.out.println("itemName:"+itemName);
		System.out.println("price:"+price);
	}
	double totalCost(int quantity){
		return price*quantity;
	}
}
public class TrackInventory {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the itemCode:");
		int code = sc.nextInt();
		
		System.out.println("Enter the itemName:");
		String name = sc.nextLine();
		
		System.out.println("Enter the price:");
		double cost = sc.nextDouble();
		
		Item item = new Item(code,name,cost);
		System.out.println("Enter the Quantity:");
		int quantity = sc.nextInt();
		
		double totalCost = item.totalCost(quantity);
		System.out.println("Total Cost for"+ quantity+"in INR"+totalCost);

	}

}

