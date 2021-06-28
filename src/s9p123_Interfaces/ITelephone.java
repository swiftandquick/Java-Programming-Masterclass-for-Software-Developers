package s9p123_Interfaces;

public interface ITelephone {

    /* Creating the signature.  */
    void powerOn();


    void dial(int phoneNumber);


    void answer();


    boolean callPhone(int phoneNumber);


    boolean isRinging();

}
