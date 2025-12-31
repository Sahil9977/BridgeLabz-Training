// Q6_countword.java
// Count the Occurrence of a Word in a File Using FileReader
package searching_algo;

import java.io.*;

public class countWord {
    public static void main(String[] args) {
        String filename = "input.txt"; // Change to your file path
        String target = "the"; // Change to your target word
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(target)) count++;
                }
            }
            System.out.println("Count of '" + target + "': " + count);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
