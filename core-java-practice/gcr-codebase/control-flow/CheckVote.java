import java.util.Scanner;

public class CheckVote {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		if(n1>=18) {
			System.out.println("The person's age is "+n1+" and can vote.");
		}
		else {
			System.out.println("The person's age is "+n1+" and cannot vote.");
		}

	}

}
