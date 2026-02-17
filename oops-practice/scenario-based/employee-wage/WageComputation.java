
package employee_wage_c.refactor;
import java.util.*;
import java.util.stream.Collectors;


public class WageComputation implements EmployeeWageBuilder {

	static int fullDayHour = 16;
	static int partTimeHour = 8;

	static Random random = new Random();

//	private  String employeeName ;
//	
//	
//	public String getEmployeeName() {
//		return employeeName;
//	}
//	
//	public void setEmployeeName(String empName) {
//		this.employeeName=empName;
//	}
	
	public static boolean checkPresence() {

		int check = random.nextInt(2);
		if(check==0) return false;
		else return true;
		
	}
	
	public static int calculateDailyWage(int wagePerHour, int fullDayHour) {
		int totalWage = wagePerHour*fullDayHour;
		return totalWage;
	}
	
	public static int calculatePartTimeWage(int wagePerHour , int partTimeHour) {
		int totalWage = wagePerHour*partTimeHour;
		return totalWage;
	}
	
	public static int employeeType() {
		
		int type = random.nextInt(2);
		switch(type) {
		case 0 :
			return 0;
		case 1 :
			return 1;
		}
		return 0;
		
	
		
	}
	List<CompanyEmpWage> companyList = new ArrayList<CompanyEmpWage>();
	
	@Override
	public void calculateMonthlyWage( ) {
		
		for(int i = 0 ;i<companyList.size();i++) {
			int totalWage=0;
			while(companyList.get(i).maxWorkingHours>0 && companyList.get(i).maxWorkingDays >0) {
				if(checkPresence()==true) {
					companyList.get(i).maxWorkingDays--;
					if(employeeType()==1) {
						companyList.get(i).maxWorkingHours-=fullDayHour;
						int daily =calculateDailyWage(companyList.get(i).wagePerHour , fullDayHour);
						companyList.get(i).dailyWage.add(daily);
						totalWage+=daily;
					}
					else  {
						companyList.get(i).maxWorkingHours-=partTimeHour;
						int daily = calculatePartTimeWage(companyList.get(i).wagePerHour,partTimeHour);	
						companyList.get(i).dailyWage.add(daily);
						totalWage+=daily;
					}
					
				}
		
			}
			companyList.get(i).totalWage=totalWage;
			System.out.println("\nCompany : "+companyList.get(i).name+"\nTotal Wage : "+companyList.get(i).totalWage);
			
			System.out.println("Daily Wage :");
			companyList.get(i).dailyWage.stream()
			.forEach( v -> System.out.print(v+" "));
			System.out.println();
		}
		
	}
	


	@Override
	public void addCompany(String name , int wagePerHour , int maxWorkinghours , int maxWorkingDays ) {
	
		companyList.add(new CompanyEmpWage(name, wagePerHour, maxWorkinghours, maxWorkingDays, maxWorkingDays));
		
	}


	@Override
	public void getTotalWage(String name) {
		 companyList.stream()
		.filter(company -> company.name.equalsIgnoreCase(name))
		.map(CompanyEmpWage:: getTotalWage)
		.forEach(System.out::println); 
	
	}
	
	

	
}


