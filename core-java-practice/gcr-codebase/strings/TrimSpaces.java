package strings;
import java.util.*;
public class TrimSpaces {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String trimmed = trimSpaces(str);
        System.out.println("Trimmed: '" + trimmed + "'");
    }

    static String trimSpaces(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == ' ') start++;
        while (end >= start && s.charAt(end) == ' ') end--;
        String trimmed = "";
        for (int i = start; i <= end; i++) trimmed += s.charAt(i);
        return trimmed;
    }

}
