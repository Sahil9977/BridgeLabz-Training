package json;

import java.io.*;
import org.json.JSONObject;

public class  MergeJSONtoJSONObject {
    public static void main(String[] args) throws Exception {
        JSONObject o1 = new JSONObject(readFile("file1.json"));
        JSONObject o2 = new JSONObject(readFile("file2.json"));

        for (String key : o2.keySet())
            o1.put(key, o2.get(key));

        BufferedWriter bw = new BufferedWriter(new FileWriter("merged.json"));
        bw.write(o1.toString(2));
        bw.close();

        System.out.println("Merged JSON saved to merged.json");
    }

    static String readFile(String path) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(path));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();
        return sb.toString();
    }
}
