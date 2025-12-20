
import java.util.*;
public class StoreMultipleValues{

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		double[] arr = new double[10];
        int i=0;
        double sum =0.0;
        while (true) { 
            int n= sc.nextInt();
            if(n<=0)break;
            else if (i==9) break;
            arr[i]=n;
            i++;  
        }
    
		for( i=0;i<10;i++) {
				sum+=arr[i];
		}
        System.err.println(sum);
		
	}

}
