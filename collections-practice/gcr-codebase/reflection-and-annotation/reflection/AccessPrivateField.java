package reflection;
import java.lang.reflect.*;
class Age{
	private int age;
	public Age(int age) {this.age=age;}
	void getAge() {System.out.println(age);}
}

public class AccessPrivateField {
	public static void main(String[] args) throws Exception{
		Age age1 = new Age(18);
		Class<?> cls = age1.getClass();
		
		Field field = cls.getDeclaredField("age");
		field.setAccessible(true);
		System.out.println(field.get(age1));
		field.set(age1, 20);
		
		Method method = cls.getDeclaredMethod("getAge");
		method.invoke(age1);

	}

}
