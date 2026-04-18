package regex;

import java.util.regex.*;

public class CapitalWordExtract{
    public static void main(String[] args) {
        extract("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.");
    }
    public static void extract(String text) {
        Pattern p = Pattern.compile("\\b[A-Z][a-zA-Z]*\\b");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Word: " + m.group());
        }
    }
}
