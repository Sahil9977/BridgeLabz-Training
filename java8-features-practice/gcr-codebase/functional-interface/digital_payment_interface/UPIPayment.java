package functional_interface.digital_payment_interface;

public class UPIPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI.");
    }
}
