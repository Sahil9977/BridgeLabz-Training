package functional_interface.payment_gateway;

public class UPIPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via UPI.");
    }

}
