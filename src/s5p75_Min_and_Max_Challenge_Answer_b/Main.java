package s5p75_Min_and_Max_Challenge_Answer_b;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Set min to highest value int can hold.
        * Set max to lowest value int can hold.
        * Any number entered will be within the range of these two numbers.  */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        /* First number flag is set to true.  */
        boolean first = true;

        while (true) {
            System.out.println("Enter number:  ");

            /* Checks if next input is an int.  */
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                int number = scanner.nextInt();

                if (number > max) {
                    max = number;
                }
                if (number < min) {
                    min = number;
                }
            }
            /* Breaks out of the loop if next input is not an int.  */
            else {
                break;
            }

            scanner.nextLine();  // Handle end of line (Enter key).
        }

        System.out.println("min = " + min + ", max = " + max);
        scanner.close();

    }

}
