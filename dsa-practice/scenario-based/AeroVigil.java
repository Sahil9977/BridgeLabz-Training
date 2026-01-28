package scnerio_based;

import java.util.HashMap;
import java.util.Scanner;

class InvalidFlightException extends Exception{
	public InvalidFlightException(String message) {
		super(message);
	}
}

class Flight{
	
//	check the flight number is in format ot not.
	public static boolean validateFlight(String flightNumber) throws InvalidFlightException {
		int maxLen = 7;
		if(flightNumber.length()!=maxLen) {
			throw new InvalidFlightException("The flight number "+flightNumber+" is invalid.");
		}
		return true;
	}
	
//	check flight name is in format or not
	public static boolean validateFlightName(String flightName) throws InvalidFlightException {
		String [] arr = {"SpiceJet" ,"Vistara","IndiGo","Air Arabia"};
		boolean check = false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals(flightName)) {
				check = true;
				break;
			}
		}
		if(!check)throw new InvalidFlightException("The flight name "+flightName+" is invalid.");
		return true;
	}
	
	//check passenger count
	public static boolean validatePassengerCount(int passengerCount , String flightName) throws InvalidFlightException{
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("SpiceJet", 396);
		hm.put("Vistara", 615);
		hm.put("IndiGo", 230);
		hm.put("Air Arabia", 130);
		if(hm.get(flightName)<=passengerCount)throw new InvalidFlightException("The passenger count "+passengerCount+" is invalid for "+flightName+".");
		return true;
	}
	
	// check fuel tank of flight
	public static double calculateFuelToFillTank(String flightName , double currentFuelLevel) throws InvalidFlightException{
		HashMap<String,Integer> hm = new HashMap<>();
		hm.put("SpiceJet", 200000);
		hm.put("Vistara", 300000);
		hm.put("IndiGo", 250000);
		hm.put("Air Arabia", 150000);
		if(currentFuelLevel<0 || hm.get(flightName)<currentFuelLevel)throw new InvalidFlightException("Invalid fuel level for "+flightName+".");
		return hm.get(flightName)-currentFuelLevel;
	}
	
}

public class AeroVigil {
	
	public static void main(String[] args) throws InvalidFlightException {
		Scanner sc = new Scanner(System.in);
		
		// take input 
		System.out.println("Enter flight details :");
		String flightDetails = sc.nextLine();
		
		String [] details = flightDetails.split(":");
//		System.out.println(Arrays.toString(details));
		
		Flight.validateFlight(details[0]);
		Flight.validateFlightName(details[1]);
		Flight.validatePassengerCount(Integer.parseInt(details[2]), details[1]);
		System.out.println("Fuel required to fill the tank: "+Flight.calculateFuelToFillTank(details[1],Integer.parseInt(details[3]))+" litres.");
		
		
		
	}
}
