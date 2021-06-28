package s5p70_Digit_Sum_Challenge_Try;

public class Main {

    public static int sumDigits(int number) {
        if (number >= 10) {
            int sum = 0;
            /* Divide n by 10 each iteration.  */
            for (int n = number; n >= 1; n = n / 10) {
                /* Remainder is the digit, add the least significant digit to the sum.  */
                sum = sum + (n % 10);
            }
            return sum;
        }
        else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(sumDigits(1));
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(11100));
    }

}
