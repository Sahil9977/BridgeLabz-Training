package future_logistics;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Goods Transport details");
		String input = sc.nextLine();
		
		Utility u = new Utility();
		
		if(u.parseDetails(input)==null)return;
		
		System.out.println("Transporter ID : "+u.parseDetails(input).getTransportId()+"\n");
		System.out.println("Date of transport : "+u.parseDetails(input).getTransportDate()+"\n");
		System.out.println("Rating of transport : "+u.parseDetails(input).getTransportRating()+"\n");
		
		
		if(u.findObjectType(u.parseDetails(input)).equalsIgnoreCase("BrickTransport")) {
			BrickTransport bt = (BrickTransport) u.parseDetails(input);//Downcasting for using the child class getter methods
			System.out.println("Quantity of bricks : "+bt.getBrickQuantity()+"\n");
			System.out.println("Brick price : "+bt.getBrickPrice()+"\n");
		}
		else {
			TimberTransport tt = (TimberTransport) u.parseDetails(input);//Downcasting for using the child class getter methods
			System.out.println("Type of timber : "+tt.getTimberType()+"\n");
			System.out.println("Timber price per kilo : "+tt.getTimberPrice()+"\n");
		}
		
		System.out.println("Vehicle of transport : "+u.parseDetails(input).vehicleSelection()+"\n");
		System.out.println("Total charge : "+u.parseDetails(input).calculateTotalCharge()+"\n");
		
	}

}
