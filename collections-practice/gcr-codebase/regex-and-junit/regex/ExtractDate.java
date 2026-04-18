package regex;

import java.util.regex.*;

public class ExtractDate{
    public static void main(String[] args) {
        extract("The dates are 12/05/2023, 15/08/2024, and 29/02/2020.");
    }

    public static void extract(String text) {
        Pattern p = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Date: " + m.group());
        }
    }
}
