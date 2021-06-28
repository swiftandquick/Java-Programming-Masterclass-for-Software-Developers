package s5p71_Parsing_Vaolues_from_a_String;

public class Main {

    public static void main(String[] args) {
        String numberAsString = "2018.125";
        System.out.println("numberAsString = " + numberAsString);

        /* Converts numberAsString (String) to double.  */
        double number = Double.parseDouble(numberAsString);
        System.out.println("number = " + number);

        numberAsString += 1;
        number += 1;

        /* 1 is append to the end of the String.  */
        System.out.println("numberAsString = " + numberAsString);

        /* Add 1 to the current value.  */
        System.out.println("number = " + number);
    }

}
