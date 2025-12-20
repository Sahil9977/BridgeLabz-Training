
import java.util.*;
public class SumTillZero {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n ;
		n = sc.nextInt();
		double total =n;
		while(n!=0) {
			n = sc.nextInt();
			total+=n;
		}
		System.out.println(total);
	}

}
