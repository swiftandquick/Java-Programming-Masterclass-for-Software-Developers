package s15p289_Challenge_3_4_and_5_b;

import java.util.concurrent.TimeUnit;
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

        boolean status = false;

        try {
            /* Acquires the lock if it is free within 1 second wait time and the current thread has not been interrupted.  */
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println("Deposite " + amount + ", " + "current balance:  $" + balance + ".  ");
                    status = true;
                }
                finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println("Could not get the lock.  ");
            }
        }
        catch(InterruptedException e) {
        }
        System.out.println("Transaction status = " + status);
    }


    public synchronized void withdraw(double amount) {

        boolean status = false;

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println("Deposite " + amount + ", " + "current balance:  $" + balance + ".  ");
                    status = true;
                }
                finally {
                    lock.unlock();
                }
            }
            else {
                System.out.println("Could not get the lock.  ");
            }
        }
        catch(InterruptedException e) {
        }
        System.out.println("Transaction status = " + status);
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }

}
