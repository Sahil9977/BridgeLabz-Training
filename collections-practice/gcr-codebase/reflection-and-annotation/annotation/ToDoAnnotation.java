package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task="Add login feature ", assignedTo="Sahil", priority="HIGH")
    public void loginAPI(){}

    @Todo(task="Add logout feature", assignedTo="Rohan")
    public void logoutAPI(){}
}

public class ToDoAnnotation {
	public static void main(String[] args) {
		
        Method[] methods = Project.class.getDeclaredMethods();
        
        for (Method m : methods) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + ": " + t.task() + " Assigned To: " + t.assignedTo() +" Priority: " + t.priority());
            }
        }
    }

}
