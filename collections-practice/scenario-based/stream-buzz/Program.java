package stream_buzz;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Program {
	
	public void RegisterCreator(CreatorStats record) {
		CreatorStats.EngagementBoard.add(record);
	}
	
	public Dictionary<String , Integer> GetTopPostCounts(List<CreatorStats> records , double likeThreshlod){
		
		Dictionary<String , Integer> d = new Hashtable<String, Integer>();
		int count =0;
		
		for(int i=0; i< records.size();i++) {
			count =0;
			for(int j=0;j<records.get(i).weeklyLikes.length;j++) {
				if(records.get(i).weeklyLikes[j]>= likeThreshlod )count++;
			}
			if(count>0)d.put(records.get(i).creatorName, count);
		}
		
		return d;
	}
	
	public double CalulateAverageLikes() {
		
		double result = 0;
		for(int i=0; i< CreatorStats.EngagementBoard.size();i++) {
			for(int j=0;j<CreatorStats.EngagementBoard.get(i).weeklyLikes.length;j++) {
				result+=CreatorStats.EngagementBoard.get(i).weeklyLikes[i];
			}
		}
		return result;

	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Program p = new Program();
		int choice;
		
		do {
			
			System.out.println(
					"\n1. Register Creator\n"
					+ "\n2. Show Top Posts\n"
					+ "\n3. Calculate Average Likes\n"
					+ "\n4. Exit\n"
					);
			
			System.out.println("\nEnter yout choice:");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
			case 1:
				
				System.out.println("\nEnter Creator Name:\n");
				String name = sc.nextLine();
				
				double [] weeklyLikes = new double[4];
				System.out.println("\nEnter weekly likes (Week 1 to 4):\n");
				for(int i=0;i<weeklyLikes.length;i++) {
					weeklyLikes[i]=sc.nextDouble();
					System.out.println();
				}
				
				CreatorStats.EngagementBoard.add(new CreatorStats(name, weeklyLikes));
				System.out.println("Creator registered successfully");
				break;
				
			case 2:
				
				System.out.println("\nEnter like threshold:\n");
				double threshold = sc.nextDouble();
				
				;
				Dictionary<String , Integer> d = p.GetTopPostCounts(CreatorStats.EngagementBoard,threshold);
				if(d.size()<=0)System.out.println(
						"\nNo top-performing posts this week."
						);
				else {
					Enumeration<String> keys = d.keys();

					while (keys.hasMoreElements()) {
					    String key = keys.nextElement();
					    System.out.println("\n"+key + " : " + d.get(key));
					}

				}
				
				break;
				
			case 3 :
				System.out.println("Overall average weekly likes:"+p.CalulateAverageLikes());
				break;
				
			case 4:
				System.out.println("Logging off --- Keep Creating with StreamBuzz!");

			default:
				break;
			}
			
		} while(choice!=4);
		
	}
}
