package s8p115_Autoboxing_and_Unboxing_Challenge_Exercise_Try;

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


    /* If customer doesn't exist, add the customer to ArrayList customers by calling Customer's constructor.  */
    public boolean newCustomer(String customer, double initialTransaction) {
        if (findCustomer(customer) != null) {
            System.out.println(customer + " already existed, cannot add.  ");
            return false;
        }
        else {
            customers.add(new Customer(customer, initialTransaction));
            System.out.println(customer + " added successfully.  ");
            return true;
        }
    }


    /* Add transaction to the customer only if the customer exists.  */
    public boolean addCustomerTransaction(String customer, double transaction) {
        if (findCustomer(customer) == null) {
            System.out.println(customer + " doesn't exist, cannot add transaction.  ");
            return false;
        }
        else {
            /* Find the index of the customer with the given name, then add transaction for the specified customer.  */
            int index = 0;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getName().equals(customer)) {
                    index = i;
                }
            }
            customers.get(index).addTransaction(transaction);
            System.out.println(transaction + " transaction for " + customer + " added successfully.  ");
            return true;
        }
    }


    private Customer findCustomer(String customer) {
        /* Check the entire ArrayList to see if the customer exists or not, if they do exist, return the customer.  */
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getName().equals(customer)) {
                return customers.get(i);
            }
        }
        return null;
    }

}
