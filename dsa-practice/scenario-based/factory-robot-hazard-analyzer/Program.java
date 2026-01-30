package factory_robot_hazard_analyzer;

import java.util.Scanner;

public class Program {
	public static void main(String[] args)  {
		RobotHazardAuditor rha = new RobotHazardAuditor();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entry Arm Precision (0.0 - 1.0):");
		double aimPrecision = sc.nextDouble();
		
		System.out.println("Entry Worker Density (1 - 20):");
		int workderDensity = sc.nextInt();
		
		System.out.println("Entry Machinery State (Worn/Faulty/Critical):");
		String machineryState = sc.next();
		
		try {
			System.out.println("Robot Hazard Risk Score:"+rha.CalculateHazardRisk(aimPrecision, workderDensity,machineryState));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
