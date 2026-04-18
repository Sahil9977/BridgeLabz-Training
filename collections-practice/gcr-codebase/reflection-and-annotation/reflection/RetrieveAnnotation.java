package reflection;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
	String name();
}

@Author(name = "SAHIL")
class Test{
	
}
public class RetrieveAnnotation {

	public static void main(String[] args) {
		Class<?> cls = Test.class;
		if(cls.isAnnotationPresent(Author.class)) {
			Author author = cls.getAnnotation(Author.class);
			System.out.println(author.name());
		}

	}

}
