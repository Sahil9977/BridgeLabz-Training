package employee_wage_c.refactor;

import java.util.Scanner;

public class EmployeeWageComputation  {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WageComputation wc = new WageComputation();
		
		wc.addCompany("TCS", 100, 150, 20);
		wc.addCompany("CG", 150, 200, 25);
		
		wc.calculateMonthlyWage();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter company name - ");
		String company = sc.nextLine() ;
		System.out.print("\nTotal Wage of "+company +" is");
		wc.getTotalWage(company);
		
	}

}
