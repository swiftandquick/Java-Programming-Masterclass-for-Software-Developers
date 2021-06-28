package s9p123_Interfaces;

public class MobilePhone implements ITelephone {

    private int myNumber;
    private boolean isRinging;
    private boolean isOn = false; // Phone is initially not on.


    public MobilePhone(int myNumber) {
        this.myNumber = myNumber;
    }


    /* Override all abstract methods from the interface.  */
    @Override
    public void powerOn() {
        isOn = true; // Turn on the phone.
        System.out.println("No action taken, desk phone does not have a power button.  ");
    }


    @Override
    public void dial(int phoneNumber) {
        if (isOn) {
            System.out.println("Now ringing " + phoneNumber + " on mobile phone.  ");
        }
        else {
            System.out.println("Phone is switched off.  ");
        }
    }


    @Override
    public void answer() {
        if(isRinging) {
            System.out.println("Answering the mobile phone.  ");
            isRinging = false;
        }
    }


    @Override
    public boolean callPhone(int phoneNumber) {
        if(phoneNumber == myNumber && isOn) {
            isRinging = true;
            System.out.println("Melody ring...  ");
        }
        else {
            isRinging = false;
            System.out.println("Mobile phone not on or number is different.  ");
        }
        return isRinging;
    }


    @Override
    public boolean isRinging() {
        return isRinging;
    }

}
