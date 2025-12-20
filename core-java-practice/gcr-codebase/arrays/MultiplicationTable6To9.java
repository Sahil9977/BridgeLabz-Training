
import java.util.*;
public class MultiplicationTable6To9 {
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[] arr = new int[10];
		for(int i=6;i<=9;i++) {
			arr[i]= n*i;
			System.out.println(n+"*"+i+"is:"+arr[i]);
		}
	}
}
