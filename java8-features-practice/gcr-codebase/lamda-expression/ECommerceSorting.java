package lamda_expression;

import java.util.*;

class Product{
	String name;
	int price;
	double rating;
	int discount;
	
	Product(String name,int price, double rating,int discount){
		this.name = name;
		this.price=price;
		this.discount=discount;
		this.rating=rating;
	}
}

public class ECommerceSorting {
	public static void main(String[] args) {
		
		 List<Product> products = new ArrayList<>();
	        products.add(new Product("charger", 30000, 4.5, 10));
	        products.add(new Product("disk", 15000, 4.7, 15));
	        products.add(new Product("ps5", 60000, 4.4, 5));
	        
	        System.out.println("Sorted using price");
	        products.sort((p1,p2)->Double.compare(p1.price,p2.price));
	        System.out.println(products.toString());
	     
	        
	        System.out.println("Sorted using rating:");
	        products.sort((p1,p2)->Double.compare(p1.rating,p2.rating));
	        System.out.println(products.toString());
	     
	       
	        System.out.println("Sorted using discount:");
	        products.sort((p1,p2)->Double.compare(p1.discount,p2.discount));
	        System.out.println(products.toString());
	      
	}

}
