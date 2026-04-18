package stream_api;

import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        String sourceFile = "C:\\Eclipse-BT\\src\\stream_api\\source.txt";     
        String destinationFile = "C:\\Eclipse-BT\\src\\stream_api\\output.txt"; 

        try (
            BufferedReader br = new BufferedReader( new FileReader(sourceFile));
            BufferedWriter bw = new BufferedWriter( new FileWriter(destinationFile));
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine(); 
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
