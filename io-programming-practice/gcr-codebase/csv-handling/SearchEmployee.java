package csv;

import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) {
        String file = "C:\\Eclipse-BT\\src\\csv\\output.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	String line=br.readLine();
        	
            while ((line = br.readLine()) != null) {
            	String[] data= line.split(",");
            	int salary = Integer.parseInt(data[3]);
            	if(salary>=50000)System.out.println("ID :"+data[0]+"  Name :"+data[1]+"  Department :"+data[2]);
            }
         
        } catch (Exception e) { e.getMessage(); }
    }
}
