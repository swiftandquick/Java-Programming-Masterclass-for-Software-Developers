package s6p79_Constructors_Part_1_Answer;

public class Main {

    public static void main(String[] args) {

        Account nomadsAccount = new Account();
        System.out.println(nomadsAccount.getNumber());
        System.out.println(nomadsAccount.getBalance());

        Account bobsAccount = new Account("12345", 0.00, "Bob Brown",
                "myemail@bob.com", "(087) 123-4567");
        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());

        bobsAccount.withdrawal(100);

        bobsAccount.deposit(50.0);
        bobsAccount.withdrawal(100);

        bobsAccount.deposit(51);
        bobsAccount.withdrawal(100);

        Account timsAccount = new Account("Tim",
                "tim@email.com", "12345");

        System.out.println(timsAccount.getNumber() + " name " + timsAccount.getCustomerName());
        System.out.println("Current balance is " + timsAccount.getBalance());

        timsAccount.withdrawal(100.55);
    }

}
