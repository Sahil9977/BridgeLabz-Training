// Q1_StudentRecordManagement.java
// Singly Linked List: Student Record Management
package linked_list;

import java.util.Scanner;

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {
    private Student head;

    public void addAtBeginning(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addAtEnd(int rollNumber, String name, int age, String grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void addAtPosition(int pos, int rollNumber, String name, int age, String grade) {
        if (pos <= 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addAtEnd(rollNumber, name, age, grade);
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    public void deleteByRollNumber(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public Student searchByRollNumber(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) return temp;
            temp = temp.next;
        }
        return null;
    }

    public void displayAll() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("RollNo\tName\tAge\tGrade");
        while (temp != null) {
            System.out.println(temp.rollNumber + "\t" + temp.name + "\t" + temp.age + "\t" + temp.grade);
            temp = temp.next;
        }
    }

    public void updateGrade(int rollNumber, String newGrade) {
        Student student = searchByRollNumber(rollNumber);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Grade updated.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        StudentRecordManagement list = new StudentRecordManagement();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Add at Beginning\n2. Add at End\n3. Add at Position\n4. Delete by Roll Number\n5. Search by Roll Number\n6. Display All\n7. Update Grade\n0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int r1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n1 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a1 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String g1 = sc.nextLine();
                    list.addAtBeginning(r1, n1, a1, g1);
                    break;
                case 2:
                    System.out.print("Enter Roll Number: ");
                    int r2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n2 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a2 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String g2 = sc.nextLine();
                    list.addAtEnd(r2, n2, a2, g2);
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter Roll Number: ");
                    int r3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n3 = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int a3 = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Grade: ");
                    String g3 = sc.nextLine();
                    list.addAtPosition(pos, r3, n3, a3, g3);
                    break;
                case 4:
                    System.out.print("Enter Roll Number to delete: ");
                    int dr = sc.nextInt();
                    list.deleteByRollNumber(dr);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to search: ");
                    int sr = sc.nextInt();
                    Student found = list.searchByRollNumber(sr);
                    if (found != null) {
                        System.out.println("Found: " + found.rollNumber + ", " + found.name + ", " + found.age + ", " + found.grade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    list.displayAll();
                    break;
                case 7:
                    System.out.print("Enter Roll Number: ");
                    int ur = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new Grade: ");
                    String ug = sc.nextLine();
                    list.updateGrade(ur, ug);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
