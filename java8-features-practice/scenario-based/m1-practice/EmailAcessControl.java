package MT_PRACTICE;

import java.util.Scanner;
import java.util.regex.*;

public class EmailAcessControl {
//firstname.emplastname+digits@departmenet.company.com
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//for creating options use (s|s|S)like that or symbol and {3,}means minimum 3 
		String rgx = "^[a-z]{3,}\\.[a-z]{3,}[0-9]{4}@(sales|marketing|IT|product)\\.company\\.com$";
		Pattern p = Pattern.compile(rgx);
	
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			Matcher m = p.matcher(s);
			if(m.matches())System.out.println("Access Granted");
			else System.out.println("Acess Denied");
		}
		
	}
}
