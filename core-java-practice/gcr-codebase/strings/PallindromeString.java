package strings;

import java.util.Scanner;

public class PallindromeString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equals(rev)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

}
