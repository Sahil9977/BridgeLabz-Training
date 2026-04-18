package json;

import java.io.BufferedReader;
import java.io.FileReader;
import org.json.JSONObject;

public class ReadJSONFile {
	public static void main(String[] args) throws Exception {
		
	        BufferedReader br = new BufferedReader(new FileReader("data.json"));
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = br.readLine()) != null) {
	            sb.append(line);
	        }
	        br.close();

	        JSONObject obj = new JSONObject(sb.toString());

	        System.out.println("Name: " + obj.getString("name"));
	        System.out.println("Email: " + obj.getString("email"));
	    }
    

}
