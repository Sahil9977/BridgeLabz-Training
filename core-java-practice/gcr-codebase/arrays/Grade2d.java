
import java.util.*;
public class Grade2d {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];
        String[] remark = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print("Enter marks in " + subject + ": ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0) {
                    System.out.println("Please enter a positive value!");
                    j--;
                }
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
                remark[i] = "Level 4, above agency-normalized standards";
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
                remark[i] = "Level 3, at agency-normalized standards";
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
                remark[i] = "Level 2, approaching agency-normalized standards";
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
                remark[i] = "Level 1, well below agency-normalized standards";
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
                remark[i] = "Level 1-, too below agency-normalized standards";
            } else {
                grade[i] = 'R';
                remark[i] = "Remedial standards";
            }
        }

        System.out.println("\n--- Student Report ---");
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println("Remarks: " + remark[i]);
        }

	}

}
