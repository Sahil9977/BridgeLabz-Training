package functional_interface.data_format_utility;

import java.time.LocalDate;

public class DateFormatterTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Default Format: " + today);
        System.out.println("dd-MM-yyyy: " + DateFormatter.formatDate(today, "dd-MM-yyyy"));
        System.out.println("MMMM dd, yyyy: " + DateFormatter.formatDate(today, "MMMM dd, yyyy"));
        System.out.println("yyyy/MM/dd: " + DateFormatter.formatDate(today, "yyyy/MM/dd"));
    }
}
