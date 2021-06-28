package s5p75_Min_and_Max_Challenge_Try;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /* Type input in the Scanner.  */
        Scanner input = new Scanner(System.in);

        int min = 2147483647; // Largest int value.
        int max = -2147483648; // Smallest int value.

        while (true) {

            System.out.println("Enter a number:  ");

            boolean hasNextInt = input.hasNextInt();

            if (hasNextInt) {
                int current = input.nextInt();
                if (current < min) {
                    min = current;
                }
                if (current > max) {
                    max = current;
                }
            }
            else {
                break;
            }

            /* Handle end of line (enter key).  */
            input.nextLine();

        }

        System.out.println("Minimum #:  " + min);
        System.out.println("Maximum #:  " + max);

        /* Close the scanner.  */
        input.close();

    }

}
