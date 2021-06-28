package s8p116_LinkedList_Part_1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Tim", 54.96);
        Customer anotherCustomer;
        /* anotherCustomer is also point to the same memory location as the customer.  */
        anotherCustomer = customer;
        /* Changing the balance of second class (anotherCustomer) affect the first class' balance (customer),
        * so when I call customer.getBalance(), the balance is 54.96.  */
        anotherCustomer.setBalance(12.18);
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ":  " + intList.get(i));
        }

        /* Add 2 to index 1.  3 is pushed from index 1 to index 2.  */
        intList.add(1, 2);

        for (int i = 0; i < intList.size(); i++) {
            System.out.println(i + ":  " + intList.get(i));
        }

    }

}
