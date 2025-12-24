package class_and_object;

import java.util.Scanner;
class Circle {
    // Attribute
    double radius;

    // Constructor
    Circle(double r) {
        radius = r;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display results
    void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
}

public class CircleArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take radius input from user
        System.out.print("Enter radius of the circle: ");
        double radius = sc.nextDouble();

        // Create Circle object
        Circle c = new Circle(radius);

        // Display area and circumference
        c.displayDetails();

        sc.close();
    }
}