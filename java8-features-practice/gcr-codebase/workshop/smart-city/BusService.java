package smart_city;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusService implements TransportService {
	
    @Override
    public List<String> getSchedules() {
    	
    	List<String> list = new ArrayList<String>();
    	list.add("Bus 1 - 8:30AM");
    	list.add("Bus 2 - 1:00PM");
    	
        return list ;
    }
}
