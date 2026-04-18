package regex;

import java.util.regex.*;

public class CensorBadWord {
    public static void main(String[] args) {
    	String [] s = {"damn", "stupid"};
        System.out.println(censor("This is a damn bad example with some stupid words.", s));
    }
    public static String censor(String text, String[] badWords) {
        for (String bad : badWords) {
            Pattern p = Pattern.compile("(?i)" + bad);
            Matcher m = p.matcher(text);
            text = m.replaceAll("****");
        }
        return text;
    }
}
