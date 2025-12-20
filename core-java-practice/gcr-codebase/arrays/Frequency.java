
import java.util.*;
public class Frequency {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[] frequency= new int[10];
		int count =0;
		
		while(n>0) {
			int digit = n%10;
			frequency[digit]++;
			n /= 10;
		}
		System.out.println("Digit of Frequency is:");
		for(int i=0;i<10;i++) {
			if(frequency[i]>0) {
				System.out.println("digit"+i+":"+frequency[i]+"times");
			}
		}
	}

}
