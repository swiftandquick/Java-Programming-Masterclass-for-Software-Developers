package s11p151_The_Final_Statement;

public class ExtendedPassword extends Password {

    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }


    /* Cannot override a static method.  */
    /*
    @Override
    public void storePassword() {
        System.out.println("Saving password as " + decryptedPassword);
    }
     */
}
