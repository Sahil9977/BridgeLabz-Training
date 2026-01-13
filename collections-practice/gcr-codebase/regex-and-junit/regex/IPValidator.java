package regex;

import java.util.regex.*;

public class IPValidator {
    public static void main(String[] args) {
        System.out.println(validate("192.168.1.1")); // true
        System.out.println(validate("999.10.0.1"));  // false
    }
    public static boolean validate(String ip) {
        String regex = "^((25[0-5]|2[0-4]\\d|[0-1]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[0-1]?\\d\\d?)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(ip);
        return m.matches();
    }
}
