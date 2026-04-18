// Q5_filereadline.java
// Read a File Line by Line Using FileReader
package searching_algo;

import java.io.*;

public class filerReadline {
    public static void main(String[] args) {
        String filename = "input.txt"; // Change to your file path
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
