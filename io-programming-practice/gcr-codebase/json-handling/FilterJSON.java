package json;

import java.io.*;
import org.json.*;

public class FilterJSON {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("users.json"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();

        JSONArray arr = new JSONArray(sb.toString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject o = arr.getJSONObject(i);
            if (o.getInt("age") > 25)
                System.out.println(o);
        }
    }
}
