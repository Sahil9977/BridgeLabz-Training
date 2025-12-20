package Level_2;

import java.util.Scanner;

public class PrintEvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                System.out.println(i + " is even number");
            else
                System.out.println(i + " is odd number");
        }
    }
}
