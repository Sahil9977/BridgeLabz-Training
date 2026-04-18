package json;

import org.json.*;

public class StudentsJSON {
	public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Rahul");
        student.put("age", 20);

        JSONArray subjects = new JSONArray();
        subjects.put("Math");
        subjects.put("Science");
        subjects.put("English");

        student.put("subjects", subjects);

        System.out.println(student.toString(1));
//        tells JSON to print with indentation of 2 spaces so output looks clean.
    }

}
