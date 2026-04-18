package reflection;
import java.lang.reflect.*;

class Student {
	 String name;
	 int rollNo;
	public Student(String name,int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}
	void display() {
		System.out.println(name);
		System.out.println(rollNo);
	}
	
	
}
public class GetClassInfo {
	public static void main(String[] args) throws Exception {
		Student student = new Student("Raj",101);
		
		//class metadata
		Class<?>  cls1 = student.getClass();
		
		//accessing field from particular object
		Field field = cls1.getDeclaredField("name");
		System.out.println(field);
		
		//modify field of object
		System.out.println(field.get(student));
		field.set(student, "sahil");
		System.out.println(field.get(student));
		
		//accessing method from object
		Method method = cls1.getDeclaredMethod("display");
		System.out.println(method);
		method.invoke(student);
		
		//create new object using reflection
	    System.out.println("create new object using reflection");
		
		// accessing constructor
		Constructor<?> constructor = cls1.getConstructor(String.class , int.class);
		
		//create a new instance using reflection
		Student student1 = (Student)constructor.newInstance("dany",102);
		Method method2 = cls1.getDeclaredMethod("display");
		method2.invoke(student1);
		
		

	}

}
