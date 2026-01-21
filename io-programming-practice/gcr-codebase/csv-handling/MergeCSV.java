package csv;
import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String f1 = "C:\\Eclipse-BT\\src\\csv\\student1.csv";
        String f2 =  "C:\\Eclipse-BT\\src\\csv\\student2.csv";
        String merged = "C:\\Eclipse-BT\\src\\csv\\merged.csv";

        Map<String,String[]> map = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(f1))) {
            br.readLine();
            String l;
            while ((l = br.readLine()) != null) {
                String[] d = l.split(",");
                map.put(d[0], d);
            }
        } catch(Exception e){}

        try (BufferedReader br = new BufferedReader(new FileReader(f2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(merged))) {

            br.readLine();
            bw.write("ID,Name,Age,Marks,Grade\n");

            String l;
            while ((l = br.readLine()) != null) {
            	System.out.println("seff");
                String[] d = l.split(",");
                String[] s = map.get(d[0]);
                System.out.println(s[0]+","+s[1]+","+s[2]+","+d[1]+","+d[2]+"\n");
                bw.write(s[0]+","+s[1]+","+s[2]+","+d[1]+","+d[2]+"\n");
            }
        } catch(Exception e){}
    }
}
