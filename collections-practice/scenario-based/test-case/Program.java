package test_case;

class BankException extends Exception{
	public BankException(String message) {
		super(message);
	}
}
public class Program {
	double balance;
	public Program(double balance) {
		this.balance=balance;
	}
	
	public void deposit(double amount) throws BankException{
		if(amount<0)throw new BankException("Deposit amount cannot be nagative");
		else balance+=amount;
	}
	
	public void withdraw(double amount) throws BankException {
		if(amount >balance)throw new BankException("Insufficiet funds");
		else balance-=amount;

	}
	
	
}
