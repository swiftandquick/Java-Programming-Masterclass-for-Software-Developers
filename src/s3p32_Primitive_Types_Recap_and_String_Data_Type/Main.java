package s3p32_Primitive_Types_Recap_and_String_Data_Type;

public class Main {

    public static void main(String[] args) {
        String myString = "This is a String";
        System.out.println("myString is equal to " + myString);

        /* Append more text to myString.  */
        myString = myString + ", and this is more.  ";
        System.out.println("myString is equal to " + myString);

        /* Append Unicode character to myString.  */
        myString = myString + " \u00A9 2019";
        System.out.println("myString is equal to " + myString);

        String numberString = "250.55";
        /* Appends more text to numberString.  */
        numberString = numberString + "49.95";
        System.out.println(numberString);

        String lastString = "10";
        int myInt = 50;
        /* Append 50 at the end of the String.  */
        lastString = lastString + myInt;
        System.out.println("LastString is equal to " + lastString);

        double doubleNumber = 120.47d;
        /* New String is created consists of the previous value of lastString plus a text
        * representation of the value of 120.47.  Then append that new String onto lastString.  */
        lastString = lastString + doubleNumber;
        System.out.println("LastString is equal to " + lastString);
    }

}
