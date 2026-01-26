package json;

import java.io.*;
import java.util.Iterator;
import org.json.JSONObject;

public class ReadJSONPrintKeysValue {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("users.json"));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null)
            sb.append(line);

        br.close();

        JSONObject obj = new JSONObject(sb.toString());

        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            System.out.println(key + " = " + obj.get(key));
        }
    }
}
