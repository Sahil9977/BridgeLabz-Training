package methods;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        System.out.println("Choose operation: 1-Add, 2-Subtract, 3-Multiply, 4-Divide");
        int op = sc.nextInt();
        switch (op) {
            case 1: System.out.println("Sum: " + add(a, b)); break;
            case 2: System.out.println("Difference: " + subtract(a, b)); break;
            case 3: System.out.println("Product: " + multiply(a, b)); break;
            case 4: System.out.println("Quotient: " + divide(a, b)); break;
            default: System.out.println("Invalid choice");
        }
    }
    static double add(double x, double y) {
        return x + y;
    }
    static double subtract(double x, double y) {
        return x - y;
    }
    static double multiply(double x, double y) {
        return x * y;
    }
    static double divide(double x, double y) {
        if (y == 0) return Double.POSITIVE_INFINITY;
        return x / y;
    }
}
