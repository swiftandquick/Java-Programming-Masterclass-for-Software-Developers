package s8ce45_Banking;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialTransaction) {
        this.name = name;
        transactions = new ArrayList<Double>();
        addTransaction(initialTransaction);
    }


    public String getName() {
        return name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }


    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

}
