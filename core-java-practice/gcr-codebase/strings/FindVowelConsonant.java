package strings;
import java.util.*;
public class FindVowelConsonant {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String input = sc.nextLine();
	        int[] counts = countVowelsConsonants(input);
	        System.out.println("Vowels: " + counts[0]);
	        System.out.println("Consonants: " + counts[1]);
	    }

	    static String getCharType(char ch) {
	        if (ch >= 'A' && ch <= 'Z') ch = (char)(ch + 32);
	        if (ch >= 'a' && ch <= 'z') {
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
	            else return "Consonant";
	        }
	        return "Not a Letter";
	    }

	    static int[] countVowelsConsonants(String s) {
	        int[] count = new int[2];
	        for (int i = 0; i < s.length(); i++) {
	            String type = getCharType(s.charAt(i));
	            if (type.equals("Vowel")) count[0]++;
	            else if (type.equals("Consonant")) count[1]++;
	        }
	        return count;
	    }

}
