package csv;

import java.io.*;
import java.util.*;

class Student {
    String id, name, marks;
    Student(String[] d){ id=d[0]; name=d[1];  marks=d[2]; }
    public String toString(){ return id+" "+name+" "+marks; }
}
public class CSVToObjects {
    public static void main(String[] args) {
    	 String file = "C:\\Eclipse-BT\\src\\csv\\students.csv";
        List<Student> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null)
                list.add(new Student(line.split(",")));

            list.forEach(System.out::println);
        } catch (Exception e) { e.printStackTrace(); }
    }
}