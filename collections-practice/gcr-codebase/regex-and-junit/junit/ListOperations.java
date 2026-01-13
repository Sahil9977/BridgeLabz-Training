package junit;
import java.util.*;
public class ListOperations {
	  public void addElement(List<Integer> list, int element) {
	        if (list != null) {
	            list.add(element);
	        }
	    }

	    public void removeElement(List<Integer> list, int element) {
	        if (list != null) {
	            list.remove(Integer.valueOf(element));
	        }
	    }

	    public int getSize(List<Integer> list) {
	        if (list != null) {
	            return list.size();
	        }
	        return 0;
	    }
}
