package Review;

import java.util.*;


public class OnlineBankingSystem {

	 static class InsufficientBalanceException extends Exception {
	        public InsufficientBalanceException(String message) {
	            super(message);
	        }
	    }
	    static abstract class Account {
	        protected int accountNumber;
	        protected String holderName;
	        protected double balance;

	        public Account(int accountNumber, String holderName, double balance) {
	            this.accountNumber = accountNumber;
	            this.holderName = holderName;
	            this.balance = balance;
	        }

	        public int getAccountNumber() {
	            return accountNumber;
	        }

	        public double getBalance() {
	            return balance;
	        }

	        public void deposit(double amount) {
	            balance += amount;
	        }

	        public void withdraw(double amount) throws InsufficientBalanceException {
	            if (balance < amount) {
	                throw new InsufficientBalanceException("Insufficient Balance!");
	            }
	            balance -= amount;
	        }

	        public abstract double calculateInterest(); 
	    }

	    // saving account
	    static class SavingsAccount extends Account {

	        public SavingsAccount(int accNo, String name, double balance) {
	            super(accNo, name, balance);
	        }

	        @Override
	        public double calculateInterest() {
	            return balance * 0.04;
	        }
	    }

	    // current account
	    static class CurrentAccount extends Account {

	        public CurrentAccount(int accNo, String name, double balance) {
	            super(accNo, name, balance);
	        }

	        @Override
	        public double calculateInterest() {
	            return balance * 0.02;
	        }
	    }

	   
	    static class Transaction {
	        String type;
	        double amount;
	        Date date;

	        public Transaction(String type, double amount) {
	            this.type = type;
	            this.amount = amount;
	            this.date = new Date();
	        }

//	        @Override
//	        public String toString() {
//	            return type + " | Amount: " + amount + " | Date: " + date;
//	        }
	    }

	 
	    interface BankService {
	        void createAccount(Account account);
	        double checkBalance(int accountNumber);
	        void deposit(int accountNumber , double amount);
	        void withdrawl(int accountNumber, double amount)throws InsufficientBalanceException;
	        void transferMoney(int fromAcc, int toAcc, double amount) throws InsufficientBalanceException;
	        List<Transaction> getTransactionHistory(int accountNumber);
	    }

	    static class BankServiceImplmentation implements BankService {

	        private Map<Integer, Account> accounts = new HashMap<>();
	        private Map<Integer, LinkedList<Transaction>> transactions = new HashMap<>();

	        @Override
	        public void createAccount(Account account) {
	            accounts.put(account.getAccountNumber(), account);
	            transactions.put(account.getAccountNumber(), new LinkedList<>());
	            System.out.println("Account Created: " + account.getAccountNumber());
	        }

	        @Override
	        public double checkBalance(int accountNumber) {
	            return accounts.get(accountNumber).getBalance();
	        }

	        
	        @Override
	        public void deposit(int accountNumber , double amount) {
	        	Account acc = accounts.get(accountNumber);
	        	acc.deposit(amount);
	        	transactions.get(accountNumber).add(new Transaction("Debited)",amount));
	        }
	        
	        @Override
	        public void withdrawl(int accountNumber , double amount) throws InsufficientBalanceException {
	        	Account acc = accounts.get(accountNumber);
	        	acc.withdraw(amount);
	        	transactions.get(accountNumber).add(new Transaction("Credited)",amount));
	        }
	        @Override
	        public void transferMoney(int fromAcc, int toAcc, double amount)
	                throws InsufficientBalanceException {

	            Account sender = accounts.get(fromAcc);
	            Account receiver = accounts.get(toAcc);

	            sender.withdraw(amount);
	            receiver.deposit(amount);

	            transactions.get(fromAcc).add(new Transaction("Debited", amount));
	            transactions.get(toAcc).add(new Transaction("Credited", amount));

	            System.out.println("Transferred " + amount +
	                    " from " + fromAcc + " to " + toAcc);
	        }

	        @Override
	        public List<Transaction> getTransactionHistory(int accountNumber) {
	            return transactions.get(accountNumber);
	        }
	    }

	    public static void main(String[] args) {

	        BankService bankService = new BankServiceImplmentation();

	        Account acc1 = new SavingsAccount(8501, "Sahil", 10000);
	        Account acc2 = new CurrentAccount(1943, "Prakash", 5000);

	        bankService.createAccount(acc1);
	        bankService.createAccount(acc2);

	        try {
	            bankService.transferMoney(8501, 1943, 2000);
	            bankService.transferMoney(8501, 1943, 1000);
	        } catch (InsufficientBalanceException e) {
	            System.out.println(e.getMessage());
	        }

	        System.out.println("\nFinal Balances:");
	        System.out.println("Account 8501: " + bankService.checkBalance(8501));
	        System.out.println("Account 1943: " + bankService.checkBalance(1943));

	        bankService.deposit(8501 , 200);
	        System.out.println("\nTransaction History for Account 8501:");
	        for (Transaction t : bankService.getTransactionHistory(8501)) {
	            System.out.println(t.type +" " +t.amount+"on"+t.date);
	          
	        }
	        System.out.println("\nInterest on Account 8501: " +
	                acc1.calculateInterest());
	    }
        
}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    



































    

    

   

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

