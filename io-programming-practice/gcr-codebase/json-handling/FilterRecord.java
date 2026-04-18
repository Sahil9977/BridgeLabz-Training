package json;

import java.nio.file.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class FilterRecord{
    public static void main(String[] args) throws Exception {
        String json = Files.readString(Path.of("users.json"));

        JSONArray arr = new JSONArray(json);

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);

            int age = obj.getInt("age");

            if (age > 25) {
                System.out.println(obj);
            }
        }
    }
}
