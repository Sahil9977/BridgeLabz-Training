
import java.util.*;
public class YoungestTallest {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] names= {"Amar","Akhbar","Anthony"};
		int[] ages= new int[3];
		double[] height= new double[3];
		for(int i=0;i<3;i++) {
			System.out.println("Enter the age of:"+names[i]);
			ages[i]= sc.nextInt();
			System.out.println("Enter the height of:"+names[i]);
			height[i]= sc.nextDouble();	
		}
		int yi=0;
		for(int i=0;i<3;i++) {
			if(ages[i]< ages[yi]) {
				yi=i;
			}
		}
		int ti=0;
		for(int i=0;i<3;i++) {
			if(height[i]>height[ti]) {
				ti=i;
			}
		}
		 System.out.println("\nYoungest friend is: " + names[yi]);
	     System.out.println("Tallest friend is: " + names[ti]);
		

	}

}
