
import java.util.*;
public class LargestSecondLargestNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
			int n= sc.nextInt();
			int maxDigit=10;
			int[] arr = new int[maxDigit];
			int idx=0;
			while(n!=0) {
				int digit = n%10;
				if(idx== maxDigit) {
					maxDigit *=2;
					int[] temp = new int[maxDigit];
	                for (int i = 0; i < idx; i++) {
	                    temp[i] = arr[i];
	                }
	                arr = temp;
				}
				arr[idx] = digit;
				idx++;
				n /=10;
			}
			int Largest = -1;
			int Second= -1;
			
			for (int i = 0; i < idx; i++) {
	            int current = arr[i];

	            if (current > Largest) {
	                Second = Largest;
	                Largest = current;
	            } else if (current > Second && current != Largest) {
	                Second = current;
	            }
	        }
			System.out.print("Digits in the number: ");
	        for (int i = 0; i < idx; i++) {
	            System.out.print(arr[i] + " ");
	        }

	        System.out.println("\nLargest digit: " + Largest);
	        if (Second != -1) {
	            System.out.println("Second largest digit: " + Second);
	        } else {
	            System.out.println("Second largest digit not found (all digits are the same).");
	        }
	}

}
