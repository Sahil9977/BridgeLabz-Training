package Review;
import java.util.*;
public class SmallestLagestFromArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Size of array");
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i=0;i<n;i++) arr[i]=sc.nextInt();
		int max=0;
		int min= Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(max<arr[i]) max=arr[i];
			if(arr[i]<min)min = arr[i];
		}
		System.out.println("Largest from array: "+max);
		System.out.println("Smallest from array: "+min);
	}

}
