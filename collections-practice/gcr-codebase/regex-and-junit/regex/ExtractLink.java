package regex;

import java.util.regex.*;

public class ExtractLink {
    public static void main(String[] args) {
        extract("Visit https://www.google.com and http://example.org for more info.");
    }

    public static void extract(String text) {
        Pattern p = Pattern.compile("https?://[\\w./-]+");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Link: " + m.group());
        }
    }
}
