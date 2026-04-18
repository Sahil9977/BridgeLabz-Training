package csv;

import java.io.*;

public class CountRows {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\output.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	String line=br.readLine();
        	int c=0;
            while ((line = br.readLine()) != null) {c++;}
            System.out.println(c);
        } catch (Exception e) { e.getMessage(); }
    }
}
