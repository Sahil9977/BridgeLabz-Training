package annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}


class Test {
    @BugReport(description = "Null pointer issue")
    @BugReport(description = "Wrong UI alignment")
    public void test() {
        System.out.println("Testing");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
    	Class<?> cls = Test.class;
        Method m = cls.getMethod("test");
        BugReport[] bugs = m.getAnnotationsByType(BugReport.class);

        for (BugReport b : bugs) {
            System.out.println("Bug: " + b.description());
        }
    }
}
