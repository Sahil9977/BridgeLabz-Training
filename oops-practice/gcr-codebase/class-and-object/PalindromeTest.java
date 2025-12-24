package class_and_object;

import java.util.Scanner;

//PalindromeChecker class
class PalindromeChecker {
 String text;

 // Constructor
 PalindromeChecker(String text) {
     this.text = text;
 }

 // Method to check if the text is a palindrome
 boolean isPalindrome() {
     String cleanedText = text.replaceAll("\\s+", "").toLowerCase(); // remove spaces and lowercase
     int left = 0;
     int right = cleanedText.length() - 1;

     while (left < right) {
         if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
             return false;
         }
         left++;
         right--;
     }
     return true;
 }

 // Method to display result
 void displayResult() {
     if (isPalindrome()) {
         System.out.println("\"" + text + "\" is a Palindrome.");
     } else {
         System.out.println("\"" + text + "\" is NOT a Palindrome.");
     }
 }
}

//Main class
public class PalindromeTest {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Input from user
     System.out.print("Enter a string to check for palindrome: ");
     String input = sc.nextLine();

     // Create object and display result
     PalindromeChecker checker = new PalindromeChecker(input);
     checker.displayResult();

     sc.close();
 }
}

