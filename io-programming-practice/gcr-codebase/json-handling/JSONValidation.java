package json;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONValidation {
	public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        String validJson = "{\"name\":\"Rahul\"}";
        String invalidJson = "{name:Rahul}"; 
        System.out.println("Checking valid JSON example:");
        validateJson(mapper, validJson);

        System.out.println("\nChecking invalid JSON example:");
        validateJson(mapper, invalidJson);
    }

    private static void validateJson(ObjectMapper mapper, String json) {
        try {
            mapper.readTree(json);
            System.out.println("Valid JSON: " + json);
        } catch (Exception e) {
            System.out.println("Invalid JSON: " + json);
        }
    }

}
