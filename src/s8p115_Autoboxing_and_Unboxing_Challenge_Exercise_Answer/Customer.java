package s8p115_Autoboxing_and_Unboxing_Challenge_Exercise_Answer;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;


    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialAmount);
    }


    public String getName() {
        return name;
    }


    public ArrayList<Double> getTransactions() {
        return transactions;
    }


    public void addTransaction(double amount) {
        this.transactions.add(amount);
    }

}
