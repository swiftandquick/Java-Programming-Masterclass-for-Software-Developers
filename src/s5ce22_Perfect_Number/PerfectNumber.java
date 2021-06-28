package s5ce22_Perfect_Number;

public class PerfectNumber {

    /* A perfect number is a positive integer equal to sum of its positive divisors besides itself.
    * For example, the number 6 has factors of 1, 2, and 3.  1 + 2 + 3 = 6, so 6 is perfect number.  */


    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }
        else {
            int sum = 0;
            /* The number itself is excluded as factor, so the for loop only iterates up to the 1 less than number.  */
            for (int i = 1; i < number; i++) {
                /* Sum the factors of the numbers, excluding the number itself.  */
                if (number % i == 0) {
                    sum = sum + i;
                }
            }
            /* Return true if the sum is equivalent to the number.  */
            if (sum == number) {
                return true;
            }
            else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }

}
