
import java.util.*;
public class OddEvenArray {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		if(n<=0) {
			System.out.println("Error occured");
			return;
		}
		int t= (n/2)+1;
		int[] arr_odd= new int[t];
		int[] arr_even= new int[t];
		int odd_index=0;
		int even_index=0;
		for(int i=1;i<=n;i++) {
			if(i % 2==0) {
				arr_even[even_index++]= i;
			}
			else {
				arr_odd[odd_index++]=i;
			}
		}
		System.out.println("Odd Number");
		for(int i=0;i<odd_index;i++) {
			System.out.print(arr_odd[i]);
		}
		System.out.println("\nEven Number");
		for(int i=0;i<even_index;i++) {
			System.out.print(arr_even[i]);
		}
		
	}

}
