package strings;
import java.util.*;
public class CompareSplitBIFAndManual {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] builtIn = input.split(" ");
        String[] custom = splitWordsManual(input);
        boolean result = compareArrays(builtIn, custom);
        System.out.println("Match: " + result);
    }

    static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }

    static String[] splitWordsManual(String s) {
        int spaceCount = 0;
        for (int i = 0; i < findLength(s); i++) {
            if (s.charAt(i) == ' ') spaceCount++;
        }
        int[] indexes = new int[spaceCount + 2];
        indexes[0] = -1;
        int idx = 1;
        for (int i = 0; i < findLength(s); i++) {
            if (s.charAt(i) == ' ') indexes[idx++] = i;
        }
        indexes[idx] = findLength(s);
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String w = "";
            for (int j = indexes[i] + 1; j < indexes[i + 1]; j++) {
                w += s.charAt(j);
            }
            words[i] = w;
        }
        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

}
