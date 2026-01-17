package reflection;

import java.lang.reflect.*;

public class MethodExecutionTiming {

    public static void forloop() {
        for (int i = 0; i < 10000; i++) {

        }
    }

    public static void whileloop() {
        int i = 0;
        while (i < 10000) {
            i++;
        }
    }

    public static void main(String[] args) throws Exception{
        Class<?> cls = MethodExecutionTiming.class;
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (!m.getName().equals("main")) {

                long start = System.nanoTime();
                m.invoke(null);
                long end = System.nanoTime();

                long executionTime = end - start;
                System.out.println("Execution time of " + m.getName() + "(): " + executionTime + " ns");
            }
        }
    }
}
