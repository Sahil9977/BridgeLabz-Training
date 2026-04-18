package regex;

import java.util.regex.*;

public class RepeatingWord{
    public static void main(String[] args) {
        find("This is is a repeated repeated word test.");
    }

    public static void find(String text) {
        Pattern p = Pattern.compile("\\b(\\w+)\\b\\s+\\1");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Repeating Word: " + m.group(1));
        }
    }
}
