package regex;

import java.util.regex.*;

public class HexColorValidator {
    public static void main(String[] args) {

        System.out.println(validate("#FFA500")); // Valid
        System.out.println(validate("#ff4500")); // Valid
        System.out.println(validate("#123"));    // Invalid
    }

    public static boolean validate(String s) {
        Pattern pattern = Pattern.compile("^#[A-Fa-f0-9]{6}$");
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
