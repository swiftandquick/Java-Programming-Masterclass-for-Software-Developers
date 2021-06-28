package s8ce45_Banking;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;


    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<Customer>();
    }


    public String getName() {
        return name;
    }


    public ArrayList<Customer> getCustomers() {
        return customers;
    }


    public boolean newCustomer(String customer, double initialTransaction) {
        if (findCustomer(customer) != null) {
            return false;
        }
        else {
            customers.add(new Customer(customer, initialTransaction));
            return true;
        }
    }


    public boolean addCustomerTransaction(String customer, double transaction) {
        if (findCustomer(customer) == null) {
            return false;
        }
        else {
            int index = 0;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getName().equals(customer)) {
                    index = i;
                }
            }
            customers.get(index).addTransaction(transaction);
            return true;
        }
    }


    private Customer findCustomer(String customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customer)) {
                return customers.get(i);
            }
        }
        return null;
    }

}
