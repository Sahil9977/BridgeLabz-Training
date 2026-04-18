package stream_api;

import java.io.*;

public class StudentDataStream {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        writeStudentData();
        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
           
            dos.writeInt(101);          
            dos.writeUTF("Alice");      
            dos.writeDouble(8.7);      

            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(9.1);

            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(7.8);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Reading student details from file:");
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll: " + roll + ", Name: " + name + ", GPA: " + gpa);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
