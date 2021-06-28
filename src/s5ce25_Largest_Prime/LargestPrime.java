package s5ce25_Largest_Prime;

public class LargestPrime {

    public static int getLargestPrime(int number) {
        /* Number cannot be negative, 0 and 1 can't contain prime numbers.  */
        if (number <= 1) {
            return -1;
        }
        else {
            int largestPrime = 2;
            for (int i = 2; i <= number; i++) {
                if (number % i == 0 && isPrime(i)) {
                    largestPrime = i;
                }
            }
            return largestPrime;
        }
    }


    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
        System.out.println(getLargestPrime(217));
        System.out.println(getLargestPrime(0));
        System.out.println(getLargestPrime(45));
        System.out.println(getLargestPrime(-1));
    }

}
