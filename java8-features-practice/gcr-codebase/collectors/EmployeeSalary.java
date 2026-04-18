package collectors;


import java.util.*;
import java.util.stream.*;

class EmployeeSalary {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Rahul", "IT", 50000),
                new Employee("Amit", "HR", 40000),
                new Employee("Neha", "IT", 60000)
        );

        Map<String, Double> avgSalary =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        ));

        System.out.println(avgSalary);
    }
}

class Employee {
    private String name;
    private String department;
    private double salary;

    Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() { return department; }
    double getSalary() { return salary; }
}
