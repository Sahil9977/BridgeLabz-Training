package functional_interface.smart_device;

public class AC implements Device {
    @Override
    public void turnOn() {
        System.out.println("AC is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("AC is turned OFF.");
    }
}
