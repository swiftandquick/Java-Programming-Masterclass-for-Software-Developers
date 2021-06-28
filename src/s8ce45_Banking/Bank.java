package s8ce45_Banking;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;


    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }


    public boolean addBranch(String branch) {
        if (findBranch(branch) != null) {
            return false;
        }
        else {
            branches.add(new Branch(branch));
            return true;
        }
    }


    public boolean addCustomer(String branch, String customer, double initialTransaction) {
        Branch thisBranch = findBranch(branch);
        if (thisBranch == null) {
            return false;
        }
        else {
            return thisBranch.newCustomer(customer, initialTransaction);
        }
    }


    public boolean addCustomerTransaction(String branch, String customer, double transaction) {
        Branch thisBranch = findBranch(branch);
        if (thisBranch == null) {
            return false;
        }
        else {
            return thisBranch.addCustomerTransaction(customer, transaction);
        }
    }


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
            return false;
        }
        else {
            System.out.println("Customer details for branch " + thisBranch.getName());
            for(int i = 0; i < thisBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + thisBranch.getCustomers().get(i).getName() + "[" + (i + 1) + "]");
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