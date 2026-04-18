package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Performance {

    @LogExecutionTime
    public void forLoop() {
        for(int i=0;i<100000;i++) {}
    }

    @LogExecutionTime
    public void whileLoop() {
        int i=0;
        while(i<100000) i++;
    }
}


public class LoggingMethodExecutionTime {
	public static void main(String[] args) throws Exception {
		
        Performance p = new Performance();
        Method[] methods = Performance.class.getDeclaredMethods();

        for(Method m : methods) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(p);
                long end = System.nanoTime();
                System.out.println(m.getName() + "take" + (end-start) + " ns");
            }
        }
    }

}
