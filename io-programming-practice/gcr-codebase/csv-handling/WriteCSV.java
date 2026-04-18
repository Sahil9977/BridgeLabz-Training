package csv;

import java.io.*;

public class WriteCSV {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\output.csv";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("ID,Name,Department,Salary\n");
            bw.write("1,John,HR,50000\n");
            bw.write("2,Amy,IT,60000\n");
            bw.write("3,Ron,Finance,55000\n");
            bw.write("4,Eva,IT,65000\n");
            bw.write("5,Max,HR,52000\n");
            System.out.println("CSV written successfully!");
        } catch (Exception e) { e.printStackTrace(); }
    }
}
