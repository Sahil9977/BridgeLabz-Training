package regex;

import java.util.regex.*;

public class LicensePlateValidator {
    public static void main(String[] args) {
        System.out.println(validate("AB1234")); // Valid
        System.out.println(validate("A12345")); // Invalid
    }
    public static boolean validate(String s) {
        Pattern pattern = Pattern.compile("^[A-Z]{2}[0-9]{4}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
