package s18_318_Introduction_to_Unit_Testing_with_JUnit;

public class BankAccount {

    private String firstName;
    private String lastName;
    private double balance;


    public static final int CHECKING = 1;
    public static final int SAVINGS = 2;

    private int accountType;


    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        accountType = typeOfAccount;
    }


    /* The branch argument is true if the customer is performing the transaction at a branch, with a teller.
    * It's false if the customer is performing the transaction at an ATM.  */
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }


    /* The branch argument is true if the customer is performing the transaction at a branch, with a teller.
     * It's false if the customer is performing the transaction at an ATM.  */
    public double withdraw(double amount, boolean branch) {
        /* If customer isn't withdrawing more than 500 dollars at an ATM (not with teller)...  */
        if ((amount > 500.00) & !branch) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
        return balance;
    }


    public double getBalance() {
        return balance;
    }


    public boolean isChecking() {
        return accountType == CHECKING;
    }


    /* More methods that use firstName, lastName, and perform other functions.  */

}
