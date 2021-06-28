package s5p65_The_for_Statement_Try;

public class Main {

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }


    public static boolean isPrime(int n) {

        if (n == 1) {
            return false;
        }

        /* Use for loop the check if the number n is divisible by integers >= 2.  */
        for (int i = 2; i <= (int) Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;

    }


    public static void main(String[] args) {
        System.out.println("10,000 at 2% interest = " + calculateInterest(10000.0, 2.0));
        System.out.println("10,000 at 3% interest = " + calculateInterest(10000.0, 3.0));
        System.out.println("10,000 at 4% interest = " + calculateInterest(10000.0, 4.0));
        System.out.println("10,000 at 5% interest = " + calculateInterest(10000.0, 5.0));

        /* Iterate the loop 5 times.  i starts as 0, increment by 1 each loop.
         * For loop iterates until the statement i < 5 become false.  */
        for (int i = 0; i < 5; i++) {
            System.out.println("loop " + i + " hello!");
        }

        /* Calculate the interest rate from 2% to 8%.  */
        for (int i = 2; i < 9; i++) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }

        /* Calculate the interest rate from 2% to 8%.  */
        for (int i = 8; i >= 2; i--) {
            System.out.println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }


        /* Find 3 prime numbers starting from 1.  */

        int number = 1;

        for (int count = 1; count <= 3; number++) {
            if (isPrime(number)) {
                System.out.println(number);
                count++;
            }
        }

    }

}
