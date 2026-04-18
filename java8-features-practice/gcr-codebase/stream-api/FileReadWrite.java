package stream_api;

import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) {
        
        String sourceFile = "C:\\Eclipse-BT\\src\\stream_api\\source.txt";
        String outputFile = "C:\\Eclipse-BT\\src\\stream_api\\output.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File src = new File(sourceFile);
            if (!src.exists()) {
                System.out.println("Source file does not exist: " + sourceFile);
                return;
            }

            fis = new FileInputStream(src);
            fos = new FileOutputStream(outputFile);

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully ");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

