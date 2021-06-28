package s11p149_Access_Modifier;

import java.util.ArrayList;

public class Account {

    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;


    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<Integer>();
    }


    public int getBalance() {
        return balance;
    }


    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            balance += amount;
            System.out.println(amount + " deposited.  Balance is now " + balance);
        }
        else {
            System.out.println("Cannot deposit negative sums.  ");
        }
    }


    public void withdraw(int amount) {
        int withdrawal = -amount;
        if(withdrawal < 0) {
            transactions.add(withdrawal);
            balance += withdrawal;
            System.out.println(amount + " withdrawn.  Balance is now " + balance);
        }
        else {
            System.out.println("Cannot withdraw negative sums.  ");
        }
    }


    /* transactions is an ArrayList that contains all deposit (positive) and withdrawal (negative), sum up all
    * transactions will result in account balance.  */
    public void calculateBalance() {
        balance = 0;
        for(int i : transactions) {
            balance += i;
        }
    }

}
