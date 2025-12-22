package strings;
import java.util.*;
public class VowelConsonantsPrint {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] result = getCharTypes(s);
        display(result);
    }

    static String getCharType(char ch) {
        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }

    static String[][] getCharTypes(String s) {
        int len = s.length();
        String[][] arr = new String[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = String.valueOf(s.charAt(i));
            arr[i][1] = getCharType(s.charAt(i));
        }
        return arr;
    }

    static void display(String[][] arr) {
        System.out.printf("%-10s%-15s\n", "Character", "Type");
        for (String[] a : arr) {
            System.out.printf("%-10s%-15s\n", a[0], a[1]);
        }
    }

}
