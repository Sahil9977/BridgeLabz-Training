package strings;
import java.util.Scanner;
public class Substring {
	public static String getSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        int start = input.nextInt();
        int end = input.nextInt();
        String part = getSubstring(text, start, end);
        String temp = text.substring(start, end);
        System.out.println("Using charAt: " + part);
        System.out.println("Using substring: " + temp);
        System.out.println("Are equal? " + compare(part, temp));
    }

}
