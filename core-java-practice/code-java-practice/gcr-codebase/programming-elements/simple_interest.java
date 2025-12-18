import java.util.Scanner;

public class simple_interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal");
        double principal = sc.nextDouble();
        System.out.println("Enter the Rate");
        double rate = sc.nextDouble();
        System.out.println("Enter the Time");
        double time = sc.nextDouble();
        double Simple_Interest= (principal *  rate * time) *100;
        System.out.println("Simple Interest is " + Simple_Interest);
    }
}
