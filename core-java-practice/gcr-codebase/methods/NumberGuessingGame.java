package methods;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        while (true) {
            int guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            String feedback = sc.next();
            if (feedback.equalsIgnoreCase("correct")) break;
            else if (feedback.equalsIgnoreCase("high")) high = guess - 1;
            else if (feedback.equalsIgnoreCase("low")) low = guess + 1;
        }
        System.out.println("Guessed the number!");
    }

    static int generateGuess(int low, int high) {
        return low + (int)(Math.random() * (high - low + 1));
    }
}
