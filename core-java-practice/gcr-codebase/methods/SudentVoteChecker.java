package methods;
import java.util.*;
public class SudentVoteChecker {
	public static boolean canStudentVote(int age) {
		if(age<0) {
			System.out.println("Cannot Vote");
			return false;
		}
		else {
			if(age>=18) return true;
			else return false;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr [] = new int[10];
		for(int i=0;i<arr.length;i++) {
			int n = sc.nextInt();
			System.out.println(canStudentVote(n));
			
		}
		
		

	}

}
