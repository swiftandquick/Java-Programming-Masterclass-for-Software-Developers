package s8p115_Autoboxing_and_Unboxing_Challenge_Exercise_Answer;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;


    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }


    public String getName() {
        return name;
    }


    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean newCustomer(String customerName, double initialAmount) {
        if(findCustomer(customerName) == null) {
            this.customers.add(new Customer(customerName, initialAmount));
            return true;
        }
        else {
            return false;
        }
    }


    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);
        if(existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        else {
            return false;
        }
    }


    private Customer findCustomer(String customerName) {
        for(int i = 0; i < this.customers.size(); i++) {
            if(this.customers.get(i).getName().equals(customerName)) {
                return this.customers.get(i);
            }
        }
        return null;
    }

}
