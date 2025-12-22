package strings;
import java.util.*;
public class CompareCharArray {
	public static char[] toCharArrayManually(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        char[] manual = toCharArrayManually(text);
        char[] builtin = text.toCharArray();
        System.out.println("Are arrays equal? " + compareArrays(manual, builtin));
    }

}
