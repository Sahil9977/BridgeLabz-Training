

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp= number;
        int sum = 0;
        int power = 0;

        // find that how many digit in the input number
        while(temp!=0){
            temp=temp/10;
            power++;
        }
        temp=number;
        while (temp != 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, power);
            temp /= 10;
        }
        if (sum == number) {
            System.out.println("Armstrong Number");
        } else {
            System.out.println("Not an Armstrong Number");
        }
    }
}
