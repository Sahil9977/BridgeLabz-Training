
import java.util.*;
public class CheckNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=5;
		int[] arr = new int[n];

		// take input 
		for(int i=0;i<n;i++) {
			System.out.println("Enter the"+(i+1)+"number:");
			arr[i]= sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			//positive
			if(arr[i]>0) {
				System.out.println("Positive number");
				if(arr[i] % 2 ==0) {
					System.out.println("Even");
				}
				else {
					System.out.println("Odd");
				}
			}
			
			//zero
			else if(arr[i] == 0) {
				System.out.println("Zero");
			}
			//neagtive
			else {
				System.out.println("Negative");
			}
			
		}
		//comparing
		System.out.println("Comparing first and last number");
		if(arr[0] == arr[n-1]) {
			System.out.println("Equal");
		}
		if(arr[0] > arr[n-1]) {
			System.out.println("First number is greater");
		}
		if(arr[0]< arr[n-1]) {
			System.out.println("Last number is greater");
		}
		
		}

}

