package functional_interface.payment_gateway;

public interface PaymentProcessor {
    void pay(double amount);

    default void refund(double amount) {
        System.out.println("Refunded " + amount + " via  processor.");
    }
}
