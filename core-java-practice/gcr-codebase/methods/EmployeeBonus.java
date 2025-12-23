package methods;
import java.util.*;
public class EmployeeBonus {
	public static int[][] calculateBonusAndNewSalary(int[][] employees) {
        int[][] updatedEmployees = new int[employees.length][3];
        for (int i = 0; i < employees.length; i++) {
            int salary = employees[i][0];
            int years = employees[i][1];
            int bonusPercent = years > 5 ? 5 : 2;
            int bonus = salary * bonusPercent / 100;
            updatedEmployees[i][0] = salary;
            updatedEmployees[i][1] = salary + bonus;
            updatedEmployees[i][2] = bonus;
        }
        return updatedEmployees;
    }

    public static void main(String[] args) {
        int[][] employees = new int[10][2];
        for (int i = 0; i < 10; i++) {
            employees[i][0] =10000+((int)Math.random()*10000);
            employees[i][1] =  (int)(Math.random() * 11);;
        }

        int[][] updated = calculateBonusAndNewSalary(employees);

        int totalOldSalary = 0;
        int totalNewSalary = 0;
        int totalBonus = 0;


        for (int i = 0; i < updated.length; i++) {
            totalOldSalary += updated[i][0];
            totalNewSalary += updated[i][1];
            totalBonus += updated[i][2];
            System.out.println( (i + 1) +( updated[i][0])+ updated[i][1]+(updated[i][2]));
        }

        System.out.println("Total Old Salary: " + totalOldSalary);
        System.out.println("Total New Salary: " + totalNewSalary);
        System.out.println("Total Bonus: " + totalBonus);
    }

}
