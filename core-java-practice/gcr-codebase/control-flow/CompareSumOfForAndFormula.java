package Level_1;

import java.util.Scanner;

public class CompareSumOfForAndFormula {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int withformula =( n*(n+1)) /2;
		int sum = 0;
		for(int i = 1;i<=n;i++) {
			sum+=i;
		}
		if(withformula == sum) System.out.println("From both method sum is same "+sum);
	}

}
