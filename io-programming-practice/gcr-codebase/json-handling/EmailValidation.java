package json;


import java.io.*;
import org.json.JSONObject;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;

public class EmailValidation {
    public static void main(String[] args) throws Exception {
        String data = "{\"email\":\"test@gmail.com\"}";

        BufferedReader br = new BufferedReader(new FileReader("schema.json"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line);
        br.close();

        JSONObject jsonSchema = new JSONObject(sb.toString());
        JSONObject jsonData = new JSONObject(data);

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonData);

        System.out.println("Email is valid!");
    }
}
