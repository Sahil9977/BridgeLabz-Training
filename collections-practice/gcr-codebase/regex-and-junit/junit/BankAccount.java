package junit;
public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
    	if(amount <0) throw new IllegalArgumentException();
        balance += amount;
    }

    public void withdraw(double amount) {
    	if(balance<amount || amount <0) throw new IllegalArgumentException();
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
