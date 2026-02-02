package smart_city;

import java.util.*;
import java.util.stream.Collectors;

public class SmartCity {
	
    public static void main(String[] args) {
        TransportService bus = new BusService();
        TransportService metro = new MetroService();
        TransportService taxi = new TaxiService();
       
        List<TransportService> ts = new ArrayList<TransportService>();
        ts.add(bus);
        ts.add(metro);
        ts.add(taxi);
        
        List<TransportService> services = ts;

//        filter schedules containing "8"
        System.out.println("Schedules with '8':");
        services.stream()
                .flatMap(s -> s.getSchedules().stream())
                .filter(s -> s.contains("8"))
                .forEach(System.out::println);

//         dashboard 
        System.out.println("\nLive Dashboard:");
        services.forEach(TransportService::printServiceDetails);
        

       
        List<Passenger> passengers = new ArrayList<Passenger>();
        passengers.add( new Passenger("Amit", "Bus 1"));
        passengers.add( new  Passenger("Neha", "Metro 1"));
        passengers.add( new Passenger("Raj", "Taxi 1"));
       
        
        // Functional Interface with Lambda
        FareCalculator fareCalc = (distance, rate) -> distance * rate;
        double fare = fareCalc.calculateFare(10, 5); // 10 km × 5rs
        System.out.println("\nCalculated Fare :" + fare);

        double distance = GeoUtils.calculateDistance(0, 0, 3, 4);
        System.out.println("\nDistance : " + distance);
    }
}
