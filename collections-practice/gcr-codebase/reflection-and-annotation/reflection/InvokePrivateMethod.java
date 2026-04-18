package reflection;
import java.lang.reflect.*;
class Calculator{
	private static int multiply(int a,int b) {
		return a*b;
	}
}

public class InvokePrivateMethod {
	public static void main(String[] args) throws Exception {

		Class<?> cls = Calculator.class;
		
		Method method = cls.getDeclaredMethod("multiply", int.class,int.class);
		method.setAccessible(true);
		System.out.println(method.invoke(null,4,5));
	}

}
