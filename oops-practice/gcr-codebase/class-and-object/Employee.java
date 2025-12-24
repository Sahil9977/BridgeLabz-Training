package class_and_object;

import java.util.Scanner;


class EmployeeDetails {
    // Attributes
    String name;
    int id;
    double salary;
    // Constructor
    EmployeeDetails(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    // Method to display employee details
    void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name   : " + name);
        System.out.println("ID     : " + id);
        System.out.println("Salary : ₹" + salary);
    }
}

public class Employee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input from user
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        // Create Employee object
        EmployeeDetails emp = new EmployeeDetails(name, id, salary);

        // Display details
        emp.displayDetails();

        sc.close();
    }
}