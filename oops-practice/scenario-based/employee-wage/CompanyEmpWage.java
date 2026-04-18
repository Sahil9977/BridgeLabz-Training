package employee_wage_c.refactor;

import java.util.ArrayList;

public class CompanyEmpWage {

	String name ;
	int wagePerHour;
	int maxWorkingHours;
	int maxWorkingDays;
	int totalWage;

	ArrayList<Integer> dailyWage = new ArrayList<>();

	public CompanyEmpWage(String name, int wagePerHour, int maxWorkingHours, int maxWorkingDays, int totalWage) {
		
		this.name = name;
		this.wagePerHour = wagePerHour;
		this.maxWorkingHours = maxWorkingHours;
		this.maxWorkingDays = maxWorkingDays;
		this.totalWage = totalWage;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getWagePerHour() {
		return wagePerHour;
	}


	public void setWagePerHour(int wagePerHour) {
		this.wagePerHour = wagePerHour;
	}


	public int getMaxWorkingHours() {
		return maxWorkingHours;
	}


	public void setMaxWorkingHours(int maxWorkingHours) {
		this.maxWorkingHours = maxWorkingHours;
	}


	public int getMaxWorkingDays() {
		return maxWorkingDays;
	}


	public void setMaxWorkingDays(int maxWorkingDays) {
		this.maxWorkingDays = maxWorkingDays;
	}


	public int getTotalWage() {
		return totalWage;
	}


	public void setTotalWage(int totalWage) {
		this.totalWage = totalWage;
	}
	

	
}
