package s6p79_Constructors_Part_1_Answer;

public class Account {

    private String number;
    private double balance;
    private String customerName;
    private String customerEmailAddress;
    private String customerPhoneNumber;

    /* If I call the constructor with no parameters, I will end up setting default
    * values for instance variables, for example, balance will be set to 2.50.  */
    public Account() {
        this("56789", 2.50, "Default name",
                "Default address", "default phone");
        System.out.println("Empty constructor called.  ");
    }


    public Account(String customerName, String customerEmailAddress, String customerPhoneNumber) {
        this("99999", 100.55, customerName, customerEmailAddress, customerPhoneNumber);
    }


    /* Constructor overloading, more than one constructor.
    * I can use this constructor in place of setter methods to set the instance ariables.  */
    public Account(String number, double balance, String customerName,
                   String customerEmailAddress, String customerPhoneNumber) {
        System.out.println("Account constructor with parameters called.  ");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.customerEmailAddress = customerEmailAddress;
        this.customerPhoneNumber = customerPhoneNumber;
    }


    public void deposit(double depositAmount) {
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + " made.  New balance is " + this.balance);
    }


    public void withdrawal(double withdrawalAmount) {
        if (this.balance - withdrawalAmount < 0) {
            System.out.println("Only " + this.balance + " available.  Withdrawal not processed");
        }
        else {
            this.balance -= withdrawalAmount;
            System.out.println("Withdrawal of " + withdrawalAmount + " processed.  Remaining balance = " + this.balance);
        }
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        this.number = number;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }


    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }


    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }


    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}
