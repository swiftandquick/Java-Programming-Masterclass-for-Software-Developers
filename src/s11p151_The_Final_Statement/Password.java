package s11p151_The_Final_Statement;

public class Password {

    private static final int key = 748576362;
    private final int encryptedPassword;


    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptDecrypt(encryptedPassword);
    }


    /* Use XOR operator "^" to encrypt and decrypt password.  */
    private int encryptDecrypt(int password) {
        return password ^ key;
    }


    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }


    /* Call encryptDecrypt to encrypt the password from parameter, if the password is the same as encryptedPassword,
    * grant access and display a welcome message.  */
    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == encryptedPassword) {
            System.out.println("Welcome!  ");
            return true;
        }
        else {
            System.out.println("Nope, you cannot come in.  ");
            return false;
        }
    }

}
