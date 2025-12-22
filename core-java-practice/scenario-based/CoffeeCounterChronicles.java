package scnerio_based;
import java.util.*;
public class CoffeeCounterChronicles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        double gst = 0.05; // 5% GST

        while (true) {
        	//ask for coffee type	
            System.out.println("\nEnter coffee type : \n-espresso \n-latte\n-cappuccino  \n-type 'exit' to stop");
            String coffeeType = sc.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you! Cafe closed.");
                break;
            }

            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            

            double price = 0;

            // Switch for coffee type
            switch (coffeeType) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 150;
                    break;
                case "cappuccino":
                    price = 180;
                    break;
                default:
                    System.out.println("Not in menu!");
                    continue;
            }

            double totalBill = price * quantity;
            double gstAmount = totalBill * gst;
            double finalAmount = totalBill + gstAmount;

            System.out.println("Base Amount: " + totalBill);
            System.out.println("GST (5%): " + gstAmount);
            System.out.println("Final Bill: " + finalAmount);
        }

     
    }

	 

	}


