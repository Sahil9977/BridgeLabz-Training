package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Test1 {

    @ImportantMethod(level = "MEDIUM")
    public void method1() {}

    @ImportantMethod
    public void method2() {}

    public void method3() {}
}

public class MarkImportantMethods {

	public static void main(String[] args) {
        Method[] methods = Test1.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod info = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + "Level: " + info.level());
            }
        }
    }
}
