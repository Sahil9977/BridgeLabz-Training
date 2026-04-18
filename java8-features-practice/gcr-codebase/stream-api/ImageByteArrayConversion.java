package stream_api;

import java.io.*;
import java.util.Arrays;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";     
        String outputImage = "copy.jpg";  

        try { 
            byte[] imageBytes = readFileToByteArray(sourceImage);

            byte[] processedBytes = processBytes(imageBytes);

            writeByteArrayToFile(processedBytes, outputImage);

            if (Arrays.equals(imageBytes, processedBytes)) {
                System.out.println("new file is same to the original image.");
            } else {
                System.out.println("Files differ");
            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }

    private static byte[] readFileToByteArray(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; 
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static byte[] processBytes(byte[] inputBytes) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(inputBytes);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToFile(byte[] data, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(data);
        }
    }
}
