package reflection;
import java.lang.reflect.*;
import java.util.*;

public class MathOperations {
	public static void add(int a , int b ) {System.out.println(a+b);}
	public static void subtract(int a , int b ) {System.out.println(a-b);}
	public static void multiply(int a , int b ) {System.out.println(a*b);}

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter: \nTYPE \"add\" \nType \"subtract\" \nType \"multiply\"");
		String oprtn = sc.next();
		 
		 
		Class<?> cls = MathOperations.class;
		Method method1 = cls.getDeclaredMethod(oprtn,int.class,int.class);
		method1.invoke(null, 8,5);
		

	}

}
