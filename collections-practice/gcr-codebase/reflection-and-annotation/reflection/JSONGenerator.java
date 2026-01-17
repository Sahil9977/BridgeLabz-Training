package reflection;

import java.lang.reflect.Field;

class Employee {
    public String name;
    public int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class JSONGenerator {
	
    public static String toJSON(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        
        for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                json.append("\"").append(fields[i].getName()).append("\": ");
                json.append("\"").append(fields[i].get(obj)).append("\"");
                if (i < fields.length - 1) json.append(", ");
         }
         json.append("}");
      

        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Employee emp = new Employee("SV", 30000);
        System.out.println(toJSON(emp));
    }
}
