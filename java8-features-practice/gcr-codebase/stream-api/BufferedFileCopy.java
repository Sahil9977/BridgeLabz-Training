package stream_api;

import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; 

    public static void main(String[] args) {
        String sourceFile = "large_source_file.dat";   
        String destUnbuffered = "copy_unbuffered.dat";
        String destBuffered = "copy_buffered.dat";

       
        long unbufferedTime = copyUnbuffered(sourceFile, destUnbuffered);
        System.out.println("Unbuffered copy time: " + unbufferedTime + " nanoseconds");

        long bufferedTime = copyBuffered(sourceFile, destBuffered);
        System.out.println("Buffered copy time: " + bufferedTime + " nanoseconds");

        if (bufferedTime < unbufferedTime) {
            System.out.println(" Buffered copy is faster by " + (unbufferedTime - bufferedTime) + " ns");
        } else {
            System.out.println("Unbuffered copy is faster (unexpected)");
        }
    }

    private static long copyUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

        } catch (IOException e) {
            System.out.println("Error (Unbuffered): " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    private static long copyBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error (Buffered): " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
