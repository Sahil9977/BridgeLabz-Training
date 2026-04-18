package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class Task {

    @TaskInfo(priority = "HIGH", assignedTo = "Sahil")
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
    	Class<?> cls = Task.class;
        Method m = cls.getMethod("completeTask");
        
        TaskInfo info = m.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());
    }
}
