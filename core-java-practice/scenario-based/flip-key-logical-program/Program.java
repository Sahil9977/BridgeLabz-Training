package scnerio_based;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the word");
		String input = sc.nextLine();
		
		if(CleanseAndInvent(input).length()<1)System.out.println("Invalid Input");
		else System.out.println(CleanseAndInvent(input));
		
		
	}
	
	public static  String CleanseAndInvent(String input) {
		if(input.length()<6 || input.equals(null))return "";
		String regex = "[^a-zA-Z]";
		Matcher matcher= Pattern.compile(regex).matcher(input);

		if(input.contains(" ") || matcher.find())return "";
		
		String temp="";
		
		for(int i=0;i<input.length();i++) {
			if(input.toLowerCase().charAt(i)%2!=0)temp+=input.charAt(i);
		}
		
		String updatedInput = new StringBuilder(temp).reverse().toString();
	
		String result ="";
		for(int i=0;i<updatedInput.length();i++) {
			if(i%2==0) result+=Character.toUpperCase(updatedInput.charAt(i));
			else result+=updatedInput.charAt(i);
		}
		
		return result;
		
	}

}
