package regex;

import java.util.regex.*;

public class UsernameValidator {
    public static void main(String[] args) {
        System.out.println(validate("user_123")); // Valid
        System.out.println(validate("123user"));  // Invalid
        System.out.println(validate("us"));       // Invalid
    }
    public static boolean validate(String s) {
        Pattern pattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4,14}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
