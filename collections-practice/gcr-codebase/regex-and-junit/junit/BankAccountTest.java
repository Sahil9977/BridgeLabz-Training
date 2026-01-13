package junit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setup() {
        account = new BankAccount(1000);
    }

    @Test
    void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
    	assertThrows(IllegalArgumentException.class,()->account.withdraw(2000));
    }

    @Test
    void testDepositNegativeAmount() {
    	assertThrows(IllegalArgumentException.class,()->account.deposit(-100));
    }

    @Test
    void testWithdrawNegativeAmount() {
    	assertThrows(IllegalArgumentException.class,()->account.withdraw(-100));
    }
}
