package s5ce25_Largest_Prime_b;

public class LargestPrime {

    public static int getLargestPrime(int number) {
        /* Number cannot be negative, 0 and 1 can't contain prime numbers.  */
        if (number <= 1) {
            return -1;
        }
        else {

            int largestPrime = 2;

            /* 21.  i = 2, 2 <= 21.  21 % 2 == 0 is false, break out of while loop.
            i = 3, 3 <= 21.  21 % 3 == 0, largestPrime = 3, number = 21 / 3 = 7.
            i = 4, 4 <= 7.  21 % 4 == 0 is false, break out of while loop.
            i = 5, 5 <= 7.  21 % 5 == 0 is false, break out of while loop.
            i = 6, 6 <= 7.  21 % 6 == 0 is false, break out of while loop.
            i = 7, 7 <= 7.  21 % 7 == 0, largestPrime = 7, number = 7 / 7 = 1.
            i = 8, 8 <= 1 is false, break out of the loop with largestPrime being 7.  */
            for (int i = 2; i <= number; i++) {
                while (number % i == 0) {
                    largestPrime = i;
                    number = number / i;
                }
            }

            return largestPrime;

        }
    }


    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
        System.out.println(getLargestPrime(16));
    }

}
