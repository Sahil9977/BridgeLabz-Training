package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User{
    @JsonField(name="user_name")
    String username;

    @JsonField(name="user_age")
    int age;

    User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}


public class CustomSerializationAnnotation {
	
	public static String toJson(Object obj) throws Exception {
		
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder("{ ");
        Field [] fields = cls.getDeclaredFields();
        for(Field f : fields) {
            if (f.isAnnotationPresent(JsonField.class)) {
                f.setAccessible(true);
                JsonField jf = f.getAnnotation(JsonField.class);
                sb.append("\"").append(jf.name()).append("\": ").append("\"").append(f.get(obj)).append("\", ");
            }
        }
        return sb.substring(0, sb.length()-2) + " }";
    }

    public static void main(String[] args) throws Exception {
        User u = new User("Sahil", 21);
        System.out.println(toJson(u));
    }

}
