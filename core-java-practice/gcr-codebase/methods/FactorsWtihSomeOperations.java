package methods;
import java.util.*;
public class FactorsWtihSomeOperations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] factors = getFactors(n);
        int max = getGreatestFactor(factors);
        int sum = getSumOfFactors(factors);
        int product = getProductOfFactors(factors);
        double cubeProduct = getProductOfCubes(factors);

        System.out.println("Greatest Factor: " + max);
        System.out.println("Sum of Factors: " + sum);
        System.out.println("Product of Factors: " + product);
        System.out.println("Product of Cubes of Factors: " + cubeProduct);
    }

    static int[] getFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        int[] arr = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) arr[index++] = i;
        }
        return arr;
    }

    static int getGreatestFactor(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }

    static int getSumOfFactors(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    static int getProductOfFactors(int[] arr) {
        int product = 1;
        for (int i : arr) product *= i;
        return product;
    }

    static double getProductOfCubes(int[] arr) {
        double product = 1;
        for (int i : arr) product *= Math.pow(i, 3);
        return product;
    }

}
