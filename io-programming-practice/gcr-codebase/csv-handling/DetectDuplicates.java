package csv;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\students.csv";
        Set<String> set = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (!set.add(d[0]))
                    System.out.println("Duplicate ID: " + line);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
