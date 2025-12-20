
import java.util.*;
public class StudentCanVote {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] age = new int[10];
		System.out.println("Enter the gae of 10 students");
		for(int i =0;i< age.length;i++) {
			System.out.print("Enter age for student " + (i + 1) + ": ");
            age[i] = sc.nextInt();
		}
		System.out.println("Eligibility for Voting");
		for(int i=0;i<age.length;i++) {
			if(age[i]<0 || age[i]==0) {
				System.out.println("Invalid age entered for student " + (i + 1));
			}
			else if (age[i] >= 18) {
                System.out.println("The student with the age " + age[i] + " can vote.");
            }
			else {
                System.out.println("The student with the age " + age[i] + " cannot vote.");
            }
		}
	}

}
