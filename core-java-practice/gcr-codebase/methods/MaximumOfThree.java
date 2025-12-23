package methods;

import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = input(sc), b = input(sc), c = input(sc);
        System.out.println("Maximum: " + max(a, b, c));
    }
    static int input(Scanner sc) {
        return sc.nextInt();
    }
    static int max(int x, int y, int z) {
        return Math.max(x, Math.max(y, z));
    }
}

