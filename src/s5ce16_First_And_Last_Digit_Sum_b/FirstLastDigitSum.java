package s5ce16_First_And_Last_Digit_Sum_b;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }

        else {
            /* Get the number of digits of the number.  */
            String numberS = number + "";
            int digits = numberS.length();

            int count = 0;

            int firstDigit = 0;
            int lastDigit = 0;

            for (int n = number; n > 0; n = n / 10) {
                /* Get the first digit.  */
                if (count == 0) {
                    firstDigit = n % 10;
                }
                /* If count is 1 less than the value of digits, get the last digit.  */
                if (count == digits - 1) {
                    lastDigit = n % 10;
                }
                /* Increment count by 1 for each iteration.  */
                count++;
            }

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
