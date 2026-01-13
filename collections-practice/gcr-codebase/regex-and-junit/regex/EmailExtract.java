package regex;

import java.util.regex.*;

public class EmailExtract {
    public static void main(String[] args) {
        extract("Contact us at support@example.com and info@company.org");
    }

    public static void extract(String text) {
        Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Email: " + m.group());
        }
    }
}
