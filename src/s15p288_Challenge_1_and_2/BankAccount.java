package s15p288_Challenge_1_and_2;

public class BankAccount {
    private double balance;
    private String accountNumber;


    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }


    /* Synchronized the operation to avoid thread interference.  */
    public synchronized void deposit(double amount) {
        synchronized(this) {
            balance += amount;
            System.out.println("Deposit " + amount + ", " + "current balance:  $" + balance + ".  ");
        }
    }


    public synchronized void withdraw(double amount) {
        synchronized(this) {
            balance -= amount;
            System.out.println("Withdraw " + amount + ", " + "current balance:  $" + balance + ".  ");
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

}
