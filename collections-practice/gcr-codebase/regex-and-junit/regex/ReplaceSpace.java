package regex;

import java.util.regex.*;

public class ReplaceSpace{
    public static void main(String[] args) {
        System.out.println(replace("This   is   an   example    with  multiple spaces."));
    }

    public static String replace(String text) {
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(text);
        return m.replaceAll(" ");
    }
}
