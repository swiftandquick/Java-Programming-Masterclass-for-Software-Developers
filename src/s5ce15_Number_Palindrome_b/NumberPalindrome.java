package s5ce15_Number_Palindrome_b;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        int lastDigit;
        /* Reverse variable starts as 0.  */
        int reverse = 0;

        /* Since the value of "number" will change in the while loop, I save value in the "original" variable.  */
        int original = number;

        /* If number divide by 10 gives 0, means that the number is less than 10, while loop should end by then.  */
        while (number != 0) {
            /* Get the last digit using modulo, for example, lastDigit is -1 if number is -1221.  */
            lastDigit = number % 10;

            /* I must multiply by 10 then add lastDigit several times.  For example, if the number is initially -1221.
            * 1st iteration:  Reverse value initially starts as 0, if lastDigit is 1, new reverse value is -1.
            * 2nd iteration:  Reverse value is now -1, if lastDigit is -2, new reverse value is -12.
             * 3rd iteration:  Reverse value is now -12, if lastDigit is -2, new reverse value is -122.
             * Last iteration:  Reverse value is now -122, if lastDigit is -2, new reverse value is -1221. */
            reverse = reverse * 10 + lastDigit;

            /* Divide by 10 to get rid of last digit, for example, -1221 will become -122 the next iteration.   */
            number = number / 10;
        }

        /* If original number and reverse number are equal, it is a palindrome.  */
        if (original == reverse) {
            return true;
        }
        else {
            return false;
        }

    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

}
