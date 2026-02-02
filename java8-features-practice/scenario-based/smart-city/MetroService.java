package smart_city;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetroService implements TransportService {
    @Override
    public List<String> getSchedules() {
    	
    	List<String> list = new ArrayList<String>();
    	list.add("Metro 1 - 7:00AM");
    	list.add("Metro 2 - 12:00AM");
    	
        return list ;
    }
}
