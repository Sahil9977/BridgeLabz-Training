package regex;

import java.util.regex.*;

public class LanguageExtract{
    public static void main(String[] args) {
        extract("I love Java, Python, and JavaScript, but I haven't tried Go yet.");
    }

    public static void extract(String text) {
        Pattern p = Pattern.compile("\\b(Java|Python|JavaScript|Go)\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Language: " + m.group());
        }
    }
}
