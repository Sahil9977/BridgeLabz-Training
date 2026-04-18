package csv;

import java.io.*;

public class FilterRecords {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	String line=br.readLine();
        	
            while ((line = br.readLine()) != null) {
            	String[] data= line.split(",");
            	int marks = Integer.parseInt(data[2]);
            	if(marks>=80)System.out.println("ID:"+data[0]+"Marks:"+data[2]);
            }
         
        } catch (Exception e) { e.getMessage(); }
    }
}
