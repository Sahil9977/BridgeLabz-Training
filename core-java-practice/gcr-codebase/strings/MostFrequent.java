package strings;

import java.util.Scanner;

class MostFrequent {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }
        char maxChar = str.charAt(0);
        int maxCount = freq[maxChar];

        for (int i = 1; i < str.length(); i++) {
            if (freq[str.charAt(i)] > maxCount) {
                maxCount = freq[str.charAt(i)];
                maxChar = str.charAt(i);
            }
        }
        System.out.println("Most Frequent Character: '" + maxChar + "'");
    }
}