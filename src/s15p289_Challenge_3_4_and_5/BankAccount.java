package s15p289_Challenge_3_4_and_5;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private String accountNumber;

    private Lock lock;


    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        /* Initialize lock as ReentrantLock.  */
        this.lock = new ReentrantLock();
    }


    public synchronized void deposit(double amount) {
        /* Lock the lock.  */
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposit " + amount + ", " + "current balance:  $" + balance + ".  ");
        }
        finally {
            /* Unlock the lock.  */
            lock.unlock();
        }
    }


    public synchronized void withdraw(double amount) {
        lock.lock();
        try {
            balance -= amount;
            System.out.println("Withdraw " + amount + ", " + "current balance:  $" + balance + ".  ");
        }
        finally {
            lock.unlock();
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

}
