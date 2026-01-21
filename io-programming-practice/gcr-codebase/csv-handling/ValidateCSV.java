package csv;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
    	 String file = "C:\\Eclipse-BT\\src\\csv\\contacts.csv";

        Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Pattern phone = Pattern.compile("^[0-9]{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                boolean okEmail = email.matcher(d[1]).matches();
                boolean okPhone = phone.matcher(d[2]).matches();

                if (!okEmail || !okPhone)
                    System.out.println("Invalid: " + line);
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}
