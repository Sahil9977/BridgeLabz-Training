package test_case;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.*;

public class UnitTest {
	Program account;
	@BeforeEach
	void setup(){
		account = new Program(10000);
	}
	
	@Test
	public void Test_Deposit_ValidAmount() throws BankException {
		account.deposit(2000);
		assertEquals(12000.0, account.balance);
	}
	
	@Test
	public void Test_Deposit_NegativeAmount() {
		assertThrows(BankException.class, ()->account.deposit(-1200));
	}
	
	@Test
	public void Test_Withdraw_ValidAmount() throws BankException {
		account.withdraw(1000);
		assertEquals(9000.0, account.balance);
	}

	@Test
	public void Test_Withdraw_InsufficientFunds() {
		assertThrows(BankException.class, ()->account.withdraw(20000));
	}
	
}
