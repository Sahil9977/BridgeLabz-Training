package strings;
import java.util.*;
public class FindLongestSmallestStringFromText {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        String input = sc.nextLine();
	        String[] words = splitWords(input);
	        String shortest = findShortest(words);
	        String longest = findLongest(words);
	        System.out.println("Shortest: " + shortest);
	        System.out.println("Longest: " + longest);
	    }

	    static String[] splitWords(String s) {
	        int count = 1;
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) == ' ') count++;
	        }
	        String[] words = new String[count];
	        int j = 0;
	        String temp = "";
	        for (int i = 0; i < s.length(); i++) {
	            if (s.charAt(i) != ' ') {
	                temp += s.charAt(i);
	            } else {
	                words[j++] = temp;
	                temp = "";
	            }
	        }
	        words[j] = temp;
	        return words;
	    }

	    static String findShortest(String[] arr) {
	        String min = arr[0];
	        for (String s : arr) if (s.length() < min.length()) min = s;
	        return min;
	    }

	    static String findLongest(String[] arr) {
	        String max = arr[0];
	        for (String s : arr) if (s.length() > max.length()) max = s;
	        return max;
	    }

	
}
