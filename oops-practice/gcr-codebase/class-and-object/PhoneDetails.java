package class_and_object;

import java.util.*;
class MobilePhone{
	//attibute
	String brand;
	String Model;
	double price;
	//constructor
	MobilePhone(String brand,String Model,double price){
		this.brand = brand;
		this.Model = Model;
		this.price = price;
	}
	//function to show result
	void displayDetails() {
	     System.out.println("Brand: " + brand);
	     System.out.println("Model: " + Model);
	     System.out.println("Price: ₹" + price);
	 }
	
}
public class PhoneDetails {

	public static void main(String[] args) {
		// take input
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the name of brand:");
		String brand = sc.nextLine();
		System.out.println("Enter the model");
		String Model = sc.nextLine();
		System.out.println("Enter the price");
		double price = sc.nextDouble();
		//make object
		MobilePhone Phone = new MobilePhone(brand,Model,price);
		//output
		System.out.println("Mobile Phone details");
		Phone.displayDetails();
		
		
	}

}
