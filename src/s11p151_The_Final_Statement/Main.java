package s11p151_The_Final_Statement;

public class Main {

    public static void main(String[] args) {
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

        /* I can't assign value for a second time for final variables.  */
        // one.instanceNumber = 4;

        /* PI is a static and final variable from Math class.  */
        System.out.println(Math.PI);

        int pw = 674312;

        /* The password object has the password 674312, but it's encrypted.  */
        Password password = new ExtendedPassword(pw);
        password.storePassword();

        /* Encrypts the argument, if the encrypted argument is the same as encryptedPassword, return true.  */
        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);

        System.out.println("Main method called.  ");
        SIBTest test = new SIBTest(); // Print the static block first and only once.  Then call the constructor.
        test.someMethod(); // Call someMethod().
        System.out.println("Owner is " + SIBTest.owner); // Print out the owner's name.
    }

}
