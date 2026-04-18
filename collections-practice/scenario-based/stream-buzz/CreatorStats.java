package stream_buzz;

import java.util.ArrayList;
import java.util.List;

public class CreatorStats {
	
	String creatorName;
	double [] weeklyLikes;
	
	public CreatorStats(String creatorName, double[] weeklyLikes) {
		this.creatorName = creatorName;
		this.weeklyLikes = weeklyLikes;
	}
	
	public static List<CreatorStats> EngagementBoard=new ArrayList<CreatorStats>();
}
