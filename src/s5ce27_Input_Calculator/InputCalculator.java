package s5ce27_Input_Calculator;

import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {

        /* Declare the scanner.  */
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int count = 0;
        int avg = 0;

        while (true) {

            boolean hasNextInt = input.hasNextInt();

            if (hasNextInt) {
                int current = input.nextInt();
                sum = sum + current;
                count++;
            }

            else {
                break;
            }

            /* Handle the enter key issue.  */
            input.nextLine();

        }

        /* If count happen to be greater than 0, find the average through dividing sum to count.
        * If count is 0, average remains to be 0, this conditional statement avoids divide by zero problems.  */
        if (count > 0) {
            /* Get a more accurate answer, I find the double (decimal) result of sum / count, then round it to the
            * closest integer, then I cast the result (double) to int.  */
            avg = (int) Math.round((double) sum / count);
        }

        System.out.println("SUM = " + sum + " AVG = " + avg);

        /* Close the scanner.  */
        input.close();

    }


    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

}
