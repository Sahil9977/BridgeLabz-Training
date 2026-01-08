package exceptions;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter numerator: ");
            int numerator = sc.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = sc.nextInt();
            int result = numerator / denominator;
            System.out.println( result);

        } catch (ArithmeticException e) {
            System.out.println(" Division by zero is not allowed.");
        } catch (InputMismatchException e) {
            System.out.println(" Please enter numeric values only.");
        } finally {
            sc.close();
        
        }
    }
}
