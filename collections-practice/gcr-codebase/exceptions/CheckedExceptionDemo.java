package exceptions;
import java.io.*;
public class CheckedExceptionDemo {
    public static void main(String[] args) {
        String fileName = "data.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

