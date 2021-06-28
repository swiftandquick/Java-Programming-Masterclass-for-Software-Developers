package s5ce27_Input_Calculator_b;

import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {

        Scanner scanner = new Scanner(System.in);

        int numbers = 0;
        int sum = 0;
        long average;

        while(true) {
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                int number = scanner.nextInt();
                numbers++;
                sum = sum + number;
            }
            /* Breaks out of the loop if input is not number.  */
            else {
                break;
            }
            scanner.nextLine(); // Handles enter key.
        }

        if (numbers != 0) {
            average = Math.round((double) sum / numbers);
        }
        else {
            average = 0;
        }

        System.out.println("SUM = " + sum + " AVG = " + average);

        scanner.close();

    }


    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

}