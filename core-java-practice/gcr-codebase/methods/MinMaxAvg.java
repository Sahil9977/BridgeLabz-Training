package methods;
import java.util.*;
public class MinMaxAvg {
	public static int[] generate4DigitRandomArray(int size) {
		int arr [] = new int[size];
		for(int i=0;i<size;i++) {
			arr[i]=1000+ (int)(Math.random()*1000);
		}
		return arr;
		
	}
	
	 public static double[] findAverageMinMax(int[] numbers) {
	        int sum = 0, min = numbers[0], max = numbers[0];
	        for (int number : numbers) {
	            sum += number;
	            if (number < min) min = number;
	            if (number > max) max = number;
	        }
	        double average = (double) sum / numbers.length;
	        return new double[]{average, min, max};
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = generate4DigitRandomArray(n);
		double ans [] = findAverageMinMax(arr);
		System.out.println("Average: " + ans[0]);
        System.out.println("Minimum: " + ans[1]);
        System.out.println("Maximum: " + ans[2]);
		
		

	}

}
