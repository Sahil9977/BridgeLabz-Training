package methods;
import java.util.*;
public class NumberCheckerUtility {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Is Prime: " + isPrime(n));
        System.out.println("Is Neon: " + isNeon(n));
        System.out.println("Is Spy: " + isSpy(n));
        System.out.println("Is Automorphic: " + isAutomorphic(n));
        System.out.println("Is Buzz: " + isBuzz(n));
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean isNeon(int n) {
        int sq = n * n;
        int sum = 0;
        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == n;
    }

    static boolean isSpy(int n) {
        int sum = 0, prod = 1, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            prod *= d;
            temp /= 10;
        }
        return sum == prod;
    }

    static boolean isAutomorphic(int n) {
        int sq = n * n;
        return Integer.toString(sq).endsWith(Integer.toString(n));
    }

    static boolean isBuzz(int n) {
        return n % 7 == 0 || n % 10 == 7;
    }

}
