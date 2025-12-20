
import java.util.*;
public class ReverseNumber {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int Originl =n;
		int count =0;
		int temp =n;
		while(temp>0) {
			count++;
			temp /=10;
		}
		//Store value
		int[] digit = new int[count];
		for(int i=count -1;i>=0;i--) {
			digit[i]= n%10;
			n /=10;
		}
		//Reverse
		int[] reverse = new int[count];
		for(int i=0;i<count;i++) {
			reverse[i] = digit[count-i-1];
		}
		System.out.println("Digits of" + Originl+"in reverse order");
		for(int i=0;i<count;i++) {
			System.out.println(reverse[i]);
		}
		
		

	}

}
