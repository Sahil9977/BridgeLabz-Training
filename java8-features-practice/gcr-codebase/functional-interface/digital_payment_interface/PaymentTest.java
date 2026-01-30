package functional_interface.digital_payment_interface;

public class PaymentTest {
    public static void main(String[] args) {
        Payment upi = new UPIPayment();
        Payment card = new CreditCardPayment();
        Payment wallet = new WalletPayment();

        upi.pay(500);
        card.pay(1500);
        wallet.pay(300);
    }
}
