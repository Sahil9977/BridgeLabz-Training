package regex;

import java.util.regex.*;

public class CreditCardValidator {
    public static void main(String[] args) {
        System.out.println(validate("4539876543210123")); // Visa
        System.out.println(validate("5234567890123456")); // MasterCard
        System.out.println(validate("6234567890123456")); // Invalid
    }
    public static boolean validate(String card) {
        Pattern visa = Pattern.compile("^4\\d{15}$");
        Pattern master = Pattern.compile("^5\\d{15}$");

        return visa.matcher(card).matches() || master.matcher(card).matches();
    }
}
