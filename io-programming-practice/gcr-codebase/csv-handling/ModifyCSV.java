package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ModifyCSV {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\employees.csv";
        String output = "C:\\Eclipse-BT\\src\\csv\\output.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {

               String line = br.readLine();
               bw.write(line + "\n");

               while ((line = br.readLine()) != null) {
            	   System.out.println(line);
                   String[] d = line.split(",");
                   if (d[2].equals("IT")) {
                       double sal = Double.parseDouble(d[3]);
                       sal *= 1.10;
                       d[3] = String.valueOf((int) sal);
                   }
                   bw.write(String.join(",", d) + "\n");
               }
           } catch (Exception e) { e.printStackTrace(); }


    }
}
