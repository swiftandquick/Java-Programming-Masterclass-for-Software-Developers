package s11p149_Access_Modifier;

public class Main {

    public static void main(String[] args) {
        Account timsAccount = new Account("Tim");
        timsAccount.deposit(1000);
        timsAccount.withdraw(500);
        timsAccount.withdraw(-200);
        timsAccount.deposit(-20);
        timsAccount.calculateBalance();

        /* If balance is a public variable, which can be change by use the object to get the balance variable.  */
        // timsAccount.balance = 5000;

        System.out.println("Balance on account is " + timsAccount.getBalance());
    }

}
