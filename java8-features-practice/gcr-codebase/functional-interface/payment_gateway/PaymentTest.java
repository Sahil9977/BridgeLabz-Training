package functional_interface.payment_gateway;

public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor upi = new UPIPayment();
        upi.pay(1000);
        upi.refund(500); 
    }
}
