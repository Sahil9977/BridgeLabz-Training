
package employee_wage_c;
import java.util.*;

class wageComputation {
	Random random = new Random();
	private int wagePerHour = 20;
	private int fullDayHour = 8;
	private int partTimeHour = 4;
	private int maxWorkingHours = 100;
	private int maxWorkingDays = 20;
	private String employeeName ;
	
	
	public void getEmployeeName() {
		System.out.println(employeeName);
	}
	
	public void setEmployeeName(String empName) {
		this.employeeName=empName;
	}
	
	public  boolean checkPresence() {
		
		int check = random.nextInt(2);
		if(check==0) {
			System.out.println(employeeName+"is Absent !");
			return false;
		}
		else {
			System.out.println(employeeName+"is Present !");
			return true;}
		
	}
	
	public int calculateDailyWage() {
		int totalWage = wagePerHour*fullDayHour;
		return totalWage;
	}
	
	public int calculatePartTimeWage() {
		int totalWage = wagePerHour*partTimeHour;
		return totalWage;
	}
	
	public int employeeType() {
//		System.out.println("Enter you employee type for \"part-time\" type 0 or for \"full-time\" type 1 :");
		int type = random.nextInt(2);
		switch(type) {
		case 0 :
			return 0;
		case 1 :
			return 1;
		}
		return 0;
		
	
		
	}
	public int calculateMonthlyWage() {
		int monthlyWage=0;
	
		while(maxWorkingHours>0 && maxWorkingDays >0) {
			if(checkPresence()==true) {
				maxWorkingDays--;
				if(employeeType()==1) {
					maxWorkingHours-=fullDayHour;
					monthlyWage+=calculateDailyWage();	
				}
				else  {
					maxWorkingHours-=partTimeHour;
					monthlyWage+=calculatePartTimeWage();	
				}
				
			}
	
			
		}
		return monthlyWage;
	}
	
}

public class EmployeeWageComputation{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		wageComputation newEmployee = new wageComputation();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter you display name:");
		String empName = sc.nextLine();
		newEmployee.setEmployeeName(empName);
		newEmployee.getEmployeeName();
		System.out.println("Your monthly pay is "+newEmployee.calculateMonthlyWage());

		
	}
}
