
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int physics = sc.nextInt();
        int chemistry = sc.nextInt();
        int maths = sc.nextInt();

        float average = (physics + chemistry + maths) / 3f;
        System.out.println("Average: " + average);

        if (average >= 80) {
            System.out.println("Grade: A\nRemarks: Level 4, above agency-normalized standards");
        } else if (average >= 70) {
            System.out.println("Grade: B\nRemarks: Level 3, at agency-normalized standards");
        } else if (average >= 60) {
            System.out.println("Grade: C\nRemarks: Level 2, below, but approaching agency-normalized standards");
        } else if (average >= 50) {
            System.out.println("Grade: D\nRemarks: Level 1, well below agency-normalized standards");
        } else if (average >= 40) {
            System.out.println("Grade: E\nRemarks: Level 1-, too below agency-normalized standards");
        } else {
            System.out.println("Grade: R\nRemarks: Remedial standards");
        }
    }
}