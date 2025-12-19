import java.util.*;
class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean check = true;

        if (n <= 1) {
            check = false;
        } else {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
        }

        if (check)
            System.out.println(n + "Prime Number");
        else
            System.out.println(n + "not Prime Number");
    }
}
