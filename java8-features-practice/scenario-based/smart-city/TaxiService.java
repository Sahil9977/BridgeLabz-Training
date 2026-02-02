package smart_city;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxiService implements TransportService {
    @Override
    public List<String> getSchedules() {
    	
    	List<String> list = new ArrayList<String>();
    	list.add("Taxi 1 - 8:00AM");
    	list.add("Taxi 2 - 10:00AM");
    	
        return list ;
    }
}
