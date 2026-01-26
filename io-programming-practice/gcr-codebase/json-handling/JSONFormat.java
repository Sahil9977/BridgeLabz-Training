package json;

import org.json.JSONObject;

class Car {
    String model;
    int year;
    String color;

    Car(String m, int y, String c) {
        this.model = m; this.year = y; this.color = c;
    }
}

public class JSONFormat {
	public static void main(String[] args) {
		Car c = new Car("204B",1997,"Black");
		JSONObject car = new JSONObject();
		car.put("model", c.model);
		car.put("year", c.year);
		car.put("color", c.color);
		
		System.out.println(car.toString(2));
	}
	
}
