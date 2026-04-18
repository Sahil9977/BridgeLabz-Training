package smart_city;

import java.util.Arrays;
import java.util.List;

public class AmbulanceService implements TransportService ,EmergencyService {

	 	@Override
	    public List<String> getSchedules() {
	 		return Arrays.asList("Ambulance - 24x7");
	    }

	    @Override
	    public void printServiceDetails() {
	        System.out.println("Emergency Service | Available 24x7 | Priority Access");
	    }

}
