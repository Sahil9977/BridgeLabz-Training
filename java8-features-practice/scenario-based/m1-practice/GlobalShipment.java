package MT_PRACTICE;

import java.time.LocalDate;
import java.util.Scanner;

public class GlobalShipment {
	
	public static boolean validateCode(String code) {
		boolean flag = true;
		if(!code.trim().startsWith("SHIP-")) {
			System.out.println(code+"strt");
			return false;
		}
		String [] arr1 = code.split("-");
		if(arr1[1].length()!=6) {
			System.out.println("length");
			return false;
		}
		else if(arr1[1].charAt(0)=='0') {
			System.out.println("0");
			return false;
		}
		else {
			for(int i=0;i<arr1[1].length()-2;i++) {
				if(arr1[1].charAt(i)==arr1[1].charAt(i+1)) {
					if(arr1[1].charAt(i+1)==arr1[1].charAt(i+2)) {
						System.out.println("conse");
						flag=false;
					}
				}
			}
		}
		
		
		
		return flag;
		
	}
	
	public static boolean validateDate(String Date) {
		boolean flag = true;
		
		try {
			LocalDate date = LocalDate.parse(Date);
			//date.isAfter(LocalDate.parse("2022-08-05") - this is also a way
			if(!(date.getYear()>2000 && date.getYear()<2099))flag=false;
		}
		catch(Exception e) {
			flag = false;
		}

		return flag;
		
	}
	
	public static boolean validateMode(String mode) {
		String [] arr = {"AIR","SEA","ROAD","RAIL","EXPRESS","FRIEGHT"};
		for(int i=0;i<arr.length;i++) {
			if(mode.equals(arr[i]))return true;
		}
		return false;
	}
	
	public static boolean validateWeight(String w) {
		
		if(Double.parseDouble(w)<0 || Double.parseDouble(w)>999999.99)return false;
		else if(w.charAt(0)=='0'&& w.charAt(1)!='.')return false;
		else {
			String [] arr3 = w.split("\\.");
			if(!(arr3[1].length()<=2))return false;
			else return true;
		}
		
	}
	
	public static boolean validateStatus(String ds) {
		String [] arr = {"DELIVERED" , "CANCELLED" , "IN_TRANSIT"};
		for(int i=0;i<arr.length;i++) {
			if(ds.equals(arr[i]))return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<n;i++) {
			String s = sc.nextLine();
			String [] arr = s.split("\\|");

			if(validateCode(arr[0])) {
				if(validateDate(arr[1])) {
					if(validateMode(arr[2])) {
						if(validateWeight(arr[3])){
							if(validateStatus(arr[4])) {
								System.out.println("COMPLIANT RECORD");
							}else System.out.println("NON-COMPLIANT RECORD");
						}else System.out.println("NON-COMPLIANT RECORD");
					}else System.out.println("NON-COMPLIANT RECORD");
				}else System.out.println("NON-COMPLIANT RECORD");
			}else System.out.println("NON-COMPLIANT RECORD");
		}
		
	}
	

}

