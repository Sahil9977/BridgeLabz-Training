package json;

import org.json.JSONObject;

public class MergeJSON {

	public static void main(String[] args) {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Amit");

        JSONObject obj2 = new JSONObject();
        obj2.put("email", "amit@gmail.com");

        for(String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }

        System.out.println(obj1.toString());
    }
}
