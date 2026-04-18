package reflection;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

class Test1{
	String name="";
	int age=0 ;
//	public Test1(){};
}
public class CustomObjectMapper {
	public static Object toObject(Class<?> cls , Map<String , Object> properties) throws Exception {
		Constructor<?> constructor = cls.getDeclaredConstructor();
		Object obj = constructor.newInstance();
		Field [] fields= cls.getDeclaredFields();
		for(Field field : fields) {

			field.set(obj, properties.get(field.getName()));
		}
		return obj;
	}
	public static void main(String[] args) throws Exception{
		Class<?> cls = Test1.class;
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("name","sahil");
		hm.put("age", 21);
		Test1 t= (Test1)toObject(cls , hm);
		System.out.println(t.name+"\n"+t.age);
		
		

	}

}
