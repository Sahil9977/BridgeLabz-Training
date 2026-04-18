package functional_interface.smart_device;

public class SmartHome {
    public static void main(String[] args) {
        Device light = new Light();
        Device ac = new AC();
        Device tv = new TV();

        light.turnOn();
        ac.turnOn();
        tv.turnOn();

        light.turnOff();
        ac.turnOff();
        tv.turnOff();
    }
}
