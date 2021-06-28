package s5p74_Reading_User_Input_Challenge_Try;

import java.util.Scanner;

public class ReadingUserInputChallenge {

    public static void main(String[] args) {
        /* Declare the scanner called input.  */
        Scanner input = new Scanner(System.in);

        int sum = 0;
        int counter = 1;

        while (counter <= 10) {

            System.out.println("Enter number #" + counter + ":  ");

            /* Checks if the next input is an integer.  */
            boolean hasNextInt = input.hasNextInt();

            if (hasNextInt) {
                int current = input.nextInt();
                sum = sum + current;
                counter++;
            }
            else {
                System.out.println("Invalid number.  ");
            }

            /* Handle end of line (enter key).  */
            input.nextLine();

        }

        System.out.println(sum);

        /* Close the scanner.  */
        input.close();
    }

}
