package Level_1;
import java.util.*;
public class CompareSumOfWhileAndFormula{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int withformula =( n*(n+1)) /2;
		int sum = 0;
		while(n!=0) {
			sum+=n;
			n--;
		}
		if(withformula == sum) System.out.println("From both method sum is same "+sum);
	}

}
