package json;

import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

class User {
    String name;
    int age;
    User(String n, int a) { name = n; age = a; }
}

public class JSONObjectToJSONArray {
    public static void main(String[] args) {
        List<User> list = Arrays.asList(
            new User("Amit", 25),
            new User("Rahul", 30)
        );

        JSONArray jsonArray = new JSONArray();

        for (User u : list) {
            JSONObject obj = new JSONObject();
            obj.put("name", u.name);
            obj.put("age", u.age);
            jsonArray.put(obj);
        }

        System.out.println(jsonArray.toString());
    }
}
