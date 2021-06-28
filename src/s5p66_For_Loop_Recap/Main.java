package s5p66_For_Loop_Recap;

public class Main {

    /* A way to check whether number is prime.  */
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int count = 0;
        /* Find the first 10 prime numbers between 10 and 50.  */
        for (int i = 10; i < 50; i++) {
            if(isPrime(i)) {
                count++;
                System.out.println("Number " + i + " is a prime number");
                if (count == 10) {
                    System.out.println("Exiting for loop.  ");
                    break;
                }
            }
        }
    }

}
