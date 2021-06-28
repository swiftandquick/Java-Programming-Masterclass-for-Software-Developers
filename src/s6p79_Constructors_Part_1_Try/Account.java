package s6p79_Constructors_Part_1_Try;

public class Account {

    private int accountNumber;


    public Account() {
    }


    public Account(int accountNumber, double balance, String name, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        if (balance < 0) {
            this.balance = 0;
        }
        else {
            this.balance = balance;
        }
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    private double balance;
    private String name;
    private String email;
    private String phoneNumber;


    /* Constructor used in place of setters, also use to set up values.  */



    public int getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        if (balance < 0) {
            this.balance = 0;
        }
        else {
            this.balance = balance;
        }
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Current balance:  " + balance);
    }


    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Cannot withdraw.  ");
        }
        else {
            balance = balance - amount;
        }
        System.out.println("Current balance:  " + balance);
    }

}
