package s8p115_Autoboxing_and_Unboxing_Challenge_Exercise_Try;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;


    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }


    /* Add the branch if the name of the branch doesn't exist.  */
    public boolean addBranch(String branch) {
        if (findBranch(branch) != null) {
            System.out.println(branch + " already exists.  ");
            return false;
        }
        else {
            branches.add(new Branch(branch));
            System.out.println(branch + " is added.  ");
            return true;
        }
    }


    /* If branch doesn't exist, cease operation.  Otherwise, call the newCustomer method to add a customer.  */
    public boolean addCustomer(String branch, String customer, double initialTransaction) {
        Branch thisBranch = findBranch(branch);
        if (thisBranch == null) {
            System.out.println(branch + " doesn't exist.  ");
            return false;
        }
        else {
            return thisBranch.newCustomer(customer, initialTransaction);
        }
    }


    /* If branch doesn't exist, cease operation.  Otherwise, call the addCustomerTransaction method to add transaction
    for a specified customer.  */
    public boolean addCustomerTransaction(String branch, String customer, double transaction) {
        Branch thisBranch = findBranch(branch);
        if (thisBranch == null) {
            System.out.println(branch + " doesn't exist.  ");
            return false;
        }
        else {
            return thisBranch.addCustomerTransaction(customer, transaction);
        }
    }


    /* Check each index of branches to see if the branches with the specified name exists, return the branch if it
     does exist, otherwise return null.  */
    private Branch findBranch(String branch) {
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getName().equals(branch)) {
                return branches.get(i);
            }
        }
        return null;
    }


    public boolean listCustomers(String branch, boolean printTransactions) {
        Branch thisBranch = findBranch(branch);
        if (thisBranch == null) {
            System.out.println(branch + " doesn't exist.  ");
            return false;
        }
        else {
            System.out.println("Customer details for branch " + thisBranch.getName());
            for(int i = 0; i < thisBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + thisBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
                /* Only print transactions if the boolean argument is true.  */
                if (printTransactions) {
                    System.out.println("Transactions");
                    for (int j = 0; j < thisBranch.getCustomers().get(i).getTransactions().size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount "
                                + thisBranch.getCustomers().get(i).getTransactions().get(j));
                    }
                }
            }
            return true;
        }
    }

}
