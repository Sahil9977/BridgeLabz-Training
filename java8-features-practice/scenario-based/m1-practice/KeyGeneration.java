package MT_PRACTICE;

import java.util.Scanner;

public class KeyGeneration {
	
	private static void validate(String s ) {
		
		if(s.length()<6) {
			System.out.println("Invalid Input (length < 6)");
			return;
		}
		else if(s.matches(".*\\d.*")) {
			System.out.println("Invalid Input (digit)");
			return;
		}
		else if(s.matches("^.*\\s.*$")) {
			System.out.println("Invalid Input (spaces)");
			return;
		}
		else if(s.matches("^.*\\W.*$")) {
			System.out.println("Invalid input (special character)");
		}
		else {
			String s1 = s.toLowerCase();
			String s2="";
			for(int i=0;i<s1.length();i++) {
				if(s1.charAt(i)%2!=0) s2+=s1.charAt(i);
			}
			StringBuilder sb = new StringBuilder(s2);
			sb.reverse();
			String s3 = sb.toString();
			String res="";
			for(int i=0;i<s3.length();i++) {
				if(i%2==0)res+=Character.toUpperCase(s3.charAt(i));
				else res+=s3.charAt(i);
			}
			if(res.length()<=0)System.out.println("Invalid Input (empty string)");
			else System.out.println("The generated key is - "+res);
			
		}
		
		

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n =sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			
			validate(s);

		}
	}

}
