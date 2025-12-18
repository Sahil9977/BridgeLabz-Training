import java.util.Scanner;

public class MaxHandShakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int maxHandshakes = (numberOfStudents*(numberOfStudents-1))/2;
        System.out.println(maxHandshakes);
    }
}
