package methods;
import java.util.*;
public class SmallestAndLargest {
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int[] result = findSmallestAndLargest(number1, number2, number3);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
    }

}
