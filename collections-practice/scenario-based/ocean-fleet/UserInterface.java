package ocean_fleet;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		
		VesselUtil vu = new VesselUtil();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter the number of vessels to be added\n");
		int n = sc.nextInt();
		sc.nextLine();
		
		System.out.println("\nEnter the vessesl details");
		for (int i=0;i<n;i++) {
			
			String input = sc.nextLine();
			String [] arr = input.split(":");
			
			vu.addVesselPerformance(new Vessel(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]));
		}
		
		System.out.println("\nEnter the vessel Id to check speed\n");
		String id = sc.nextLine();
		
		Vessel v = vu.getVesselById(id);
		System.out.println("\n"+v.vesselId+" | "+v.vesselName+" | "+v.vesselType+" | "+v.averageSpeed+" knots\n");
		
		if(v==null)System.out.println("\nVessel Id "+id+" not found.\n");
		
		List<Vessel> list = vu.getHighPerformanceVessel();
		
		System.out.println("\nHigh performace vessesl are\n");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).vesselId+" | "+list.get(i).vesselName+" | "+list.get(i).vesselType+" | "+list.get(i).averageSpeed+" knots\n");
		}
	}

}
