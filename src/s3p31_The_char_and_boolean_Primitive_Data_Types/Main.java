package s3p31_The_char_and_boolean_Primitive_Data_Types;

public class Main {

    public static void main(String[] args) {
        char myChar = 'D';
        char myUnicodeChar = '\u0044';

        System.out.println(myChar);
        System.out.println(myUnicodeChar);

        /* Gets the copy right symbol.  */
        char myCopyRightChar = '\u00A9';
        System.out.println(myCopyRightChar);

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;

        boolean isCustomerOverTwentyOne = true;
    }

}
