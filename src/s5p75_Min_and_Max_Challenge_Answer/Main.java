package s5p75_Min_and_Max_Challenge_Answer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int min = 0;
        int max = 0;

        /* First number flag is set to true.  */
        boolean first = true;

        while (true) {
            System.out.println("Enter number:  ");

            /* Checks if next input is an int.  */
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt) {
                int number = scanner.nextInt();

                /* Set first to false, set min and max to the first number entered.  After the first
                * iteration, the value of first will no longer be true.  */
                if (first) {
                    first = false;
                    min = number;
                    max = number;
                }

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
