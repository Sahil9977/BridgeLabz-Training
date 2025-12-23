package methods;
import java.time.LocalDate;
import java.util.Scanner;
public class DateComparison {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String d1 = sc.next();  // Format: yyyy-MM-dd
        String d2 = sc.next();

        LocalDate date1 = LocalDate.parse(d1);
        LocalDate date2 = LocalDate.parse(d2);

        if (date1.isBefore(date2)) {
            System.out.println("First date is before second.");
        } else if (date1.isAfter(date2)) {
            System.out.println("First date is after second.");
        } else if (date1.isEqual(date2)) {
            System.out.println("Both dates are equal.");
        }
    }

}
