package json;

import java.io.*;
import org.json.*;

public class JSONToXML {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.json"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();

        JSONObject obj = new JSONObject(sb.toString());
        String xml = XML.toString(obj);

        BufferedWriter bw = new BufferedWriter(new FileWriter("output.xml"));
        bw.write(xml);
        bw.close();

        System.out.println("XML written to output.xml");
    }
}
