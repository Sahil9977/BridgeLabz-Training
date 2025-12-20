
import java.util.*;
public class Grade1d {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[] grades = new int[n];
		double[] percentage= new double[n];
		int[] physics = new int[n];
	    int[] chemistry = new int[n];
	    int[] maths = new int[n];
	    String[] remark= new String[n];
	    for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("Enter marks in Physics: ");
            physics[i] = sc.nextInt();
            if (physics[i] < 0) {
                System.out.println("Please enter positive marks!");
                i--;
                continue;
            }
            System.out.print("Enter marks in Chemistry: ");
            chemistry[i] = sc.nextInt();
            if (chemistry[i] < 0) {
                System.out.println("Please enter positive marks!");
                i--;
                continue;
            }
            System.out.print("Enter marks in Maths: ");
            maths[i] = sc.nextInt();
            if (maths[i] < 0) {
                System.out.println("Please enter positive marks!");
                i--;
                continue;
            }
            
            double total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = (total / 3.0);
            
            if (percentage[i] >= 80) {
                grades[i] = 'A';
                remark[i] = "Level 4, above agency-normalized standards";
            } else if (percentage[i] >= 70) {
                grades[i] = 'B';
                remark[i] = "Level 3, at agency-normalized standards";
            } else if (percentage[i] >= 60) {
                grades[i] = 'C';
                remark[i] = "Level 2, approaching agency-normalized standards";
            } else if (percentage[i] >= 50) {
                grades[i] = 'D';
                remark[i] = "Level 1, well below agency-normalized standards";
            } else if (percentage[i] >= 40) {
                grades[i] = 'E';
                remark[i] = "Level 1-, too below agency-normalized standards";
            } else {
                grades[i] = 'R';
                remark[i] = "Remedial standards";
            }
	    }
            
            System.out.println("\n--- Student Report ---");
            for (int i1 = 0; i1 < n; i1++) {
                System.out.printf("\nStudent %d:\n", i1 + 1);
                System.out.println("Physics Marks: " + physics[i1]);
                System.out.println("Chemistry Marks: " + chemistry[i1]);
                System.out.println("Maths Marks: " + maths[i1]);
                System.out.printf("Percentage: %.2f%%\n", percentage[i1]);
                System.out.println("Grade: " + grades[i1]);
                System.out.println("Remarks: " + remark[i1]);
            }

            
            

	}

}
