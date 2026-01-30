
package functional_interface.multiple_vehicle_rental_system;

public class Bus implements Vehicle {
    @Override
    public void rent() {
        System.out.println("Bus rented successfully.");
    }

    @Override
    public void returnVehicle() {
        System.out.println("Bus returned successfully.");
    }
}
