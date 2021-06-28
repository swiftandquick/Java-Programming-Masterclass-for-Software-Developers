package s5ce16_First_And_Last_Digit_Sum_c;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        else {
            int firstDigit, lastDigit;

            /* The number value will change later, so I save the original value of number to variable "original".  */
            int original = number;

            /* Get the first digit through continue to divide by 10.
            * For example, 252 / 10 = 25, 25 / 10 = 2, and 2 >= 10 is false, exit the loop, number is now 2.  */
            while (number >= 10) {
                number = number / 10;
            }
            firstDigit = number;

            /* The last digit is the remainder of the original number divide by 10.  */
            lastDigit = original % 10;

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
