package multi_threading;

class BankAccount {
    

    void withdraw(String name, int amount) {
        System.out.println("[" + name + "] Attempting to withdraw " + amount);
        int balance = 10000;

        if (balance >= amount) {
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {}

            balance -= amount;
            System.out.println("Transaction successful: " + name +
                    ", Amount: " + amount +
                    ", Balance: " + balance);
        } else {
            System.out.println("Transaction failed: " + name +
                    ", Insufficient balance");
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    public void run() {
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
	public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000));
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000));
//        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000));
//     
        t1.start(); t2.start(); //t3.start();
    }


}
