import java.util.Scanner;

public class MaxHandShakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxHandshakes = (n*(n-1))/2;
        System.out.println(maxHandshakes);
    }
}
