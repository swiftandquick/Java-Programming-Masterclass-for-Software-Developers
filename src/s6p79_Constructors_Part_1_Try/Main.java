package s6p79_Constructors_Part_1_Try;

public class Main {

    public static void main(String[] args) {
        /* Create object (account) with template (Account).  Call the empty constructor.  */
        Account account = new Account();

        /* Set instance variables of the object account by calling setters.  */
        account.setAccountNumber(1234);
        account.setBalance(1000.00);
        account.setName("John Doe");
        account.setEmail("abc123@gmail.com");
        account.setPhoneNumber("111-111-1111");

        /* Access to account's instance variables with getters.  */
        System.out.println("Account Number:  " + account.getAccountNumber());
        System.out.println("Balance:  " + account.getBalance());
        System.out.println("Name:  " + account.getName());
        System.out.println("Email:  " + account.getEmail());
        System.out.println("Phone Number:  " + account.getPhoneNumber());

        account.deposit(1000.00); // Deposit 1000, current balance is 2000.
        account.withdraw(2050.00); // Withdraw 2050, which fails because balance is 2000, balance stays as 2000.
        account.withdraw(1000.00); // Withdraw 1000, current balance is 1000.

        /* Create object (account2) with template (Account).  Call the empty constructor.
        * Use constructor in place of setters to set up variables.  */
        Account account2 = new Account(1235, 2500.00, "Jane Doe", "def456@yahoo.com", "222-222-2222");

        /* Access to account's instance variables with getters.  */
        System.out.println("Account Number:  " + account2.getAccountNumber());
        System.out.println("Balance:  " + account2.getBalance());
        System.out.println("Name:  " + account2.getName());
        System.out.println("Email:  " + account2.getEmail());
        System.out.println("Phone Number:  " + account2.getPhoneNumber());

    }

}
