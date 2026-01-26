package json;


import java.io.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;

class User1 {
    String name; int age;
    User1(String n, int a){ name=n; age=a; }
}

public class JavaObjectToJSONArray {
    public static void main(String[] args) throws Exception {
        List<User1> list = Arrays.asList(
            new User1("Amit", 25),
            new User1("Rahul", 30)
        );

        JSONArray arr = new JSONArray();
        for (User1 u : list) {
            JSONObject obj = new JSONObject();
            obj.put("name", u.name);
            obj.put("age", u.age);
            arr.put(obj);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"));
        bw.write(arr.toString(2));
        bw.close();

        System.out.println("JSON written to output.json");
    }
}
