package future_logistics;

import java.util.Scanner;

public class Utility {
	
	public GoodsTransport parseDetails(String input) {
		String [] details = input.split(":");
		
		if(validateTransportId(details[0])) {
			if(details[3].equalsIgnoreCase("BrickTransport")) {
				return new BrickTransport(details[0], details[1], Integer.parseInt(details[2]),Float.parseFloat(details[4]) , Integer.parseInt(details[5]), Integer.parseInt(details[6]));
			}
			
			if(details[3].equalsIgnoreCase("TimberTransport")) {
				return new TimberTransport(details[0], details[1], Integer.parseInt(details[2]), Float.parseFloat(details[4]) , Float.parseFloat(details[5]),details[6], Float.parseFloat(details[7]));
			}
		}
		System.out.println("Please provide a valid record");
		return null;
		
	}
	
	//validate transport id 
	public boolean validateTransportId(String transportId) {
		String regex = "^[RTS]{3}[0-9]{3}[A-Z]$";
		if(transportId.matches(regex))return true;
		else {
			System.out.println("Transport ID "+transportId+" is invalid");
			return false;
		}
	}
	
	//find the object type
	public String findObjectType(GoodsTransport goodsTransport) {
		if(goodsTransport instanceof BrickTransport)return "BrickTransport";
		else if(goodsTransport instanceof TimberTransport) return "TimberTransport";
		else return null;
	}

	

}
