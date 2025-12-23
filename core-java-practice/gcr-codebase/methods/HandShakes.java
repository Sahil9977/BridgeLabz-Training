package methods;
import java.util.*;
public class HandShakes {

	public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = scanner.nextInt();
        int handshakes = calculateHandshakes(numberOfStudents);
        System.out.println("Handshakes: " + handshakes);
    }
}
