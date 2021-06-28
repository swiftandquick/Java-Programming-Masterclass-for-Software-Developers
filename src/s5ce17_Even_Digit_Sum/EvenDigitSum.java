package s5ce17_Even_Digit_Sum;

public class EvenDigitSum {

    public static int getEvenDigitSum(int number) {
        if (number < 0) {
            return -1;
        }

        else {
            int currentDigit;
            int sum = 0;
            /* Start checking digits from least significant to most sigficant via for loop.  */
            for (int n = number; n > 0; n = n / 10) {
                currentDigit = n % 10;
                /* If digit is event, add it to sum.  */
                if (currentDigit % 2 == 0) {
                    sum = sum + currentDigit;
                }
            }
            return sum;
        }
    }


    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }

}
