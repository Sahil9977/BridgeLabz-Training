package functional_interface.smart_vehicle_dashboard;

public class VehicleDashboardTest {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle ev = new ElectricCar();

        car.displaySpeed();
        car.displayBattery(); // default method

        ev.displaySpeed();
        ev.displayBattery(); // overridden method
    }
}
