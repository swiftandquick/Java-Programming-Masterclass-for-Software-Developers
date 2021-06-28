package s5p70_Digit_Sum_Challenge_Answer;

public class Main {

    public static int sumDigits(int number) {
        if (number >= 10) {
            int sum = 0;
            while (number > 0) {
                // Extract the least-significant digit, note that 125 % 10 = 5, 12 % 10 = 2, 1 % 10 = 1.
                int digit = number % 10;
                // Add the least significant digit to the sum.
                sum = sum + digit;
                // Drop the least-significant digit, note that 125 / 10 = 12, 12 / 10 = 1, 1 / 10 = 0.
                number = number / 10;
            }
            return sum;
        }
        else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(-125));
        System.out.println(sumDigits(4));
        System.out.println(sumDigits(32123));
    }

}
