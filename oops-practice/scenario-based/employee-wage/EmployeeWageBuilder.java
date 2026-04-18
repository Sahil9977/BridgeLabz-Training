package employee_wage_c.refactor;

public interface EmployeeWageBuilder {
	

	void addCompany(String name, int wagePerHour, int maxWorkinghours, int maxWorkingDays);
	void calculateMonthlyWage();
	void getTotalWage(String name);


}
