package functional_interface.smart_device; 

public class Light implements Device {
    @Override
    public void turnOn() {
        System.out.println("Light is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned OFF.");
    }
}
