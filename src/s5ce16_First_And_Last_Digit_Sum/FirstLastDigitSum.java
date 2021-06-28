package s5ce16_First_And_Last_Digit_Sum;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        else {
            /* Convert number to String.  */
            String numberS = number + "";

            /* Get the first character of the String.  Convert to String, then convert to int.  */
            int firstDigit = Integer.parseInt(numberS.charAt(0) + "");

            /* Get the last character of the String.  Convert to String, then convert to int.  */
            int lastDigit = Integer.parseInt(numberS.charAt(numberS.length() - 1) + "");

            /* Get the sum of firstDigit and lastDigit.  */
            return firstDigit + lastDigit;
        }
    }


    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
    }

}
