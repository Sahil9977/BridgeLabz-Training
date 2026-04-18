package functional_interface.smart_vehicle_dashboard;

public class Car implements Vehicle {
    @Override
    public void displaySpeed() {
        System.out.println("Car speed: 80 km/h");
    }

}
