
import java.util.Scanner;

public class SumTillZeroAndNegative{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n ;
		n = sc.nextInt();
		double total =n;
		while(true) {
			n = sc.nextInt();
			if(n<=0) break;
			total+=n;
			
		}
		System.out.println(total);
	
	}

}
