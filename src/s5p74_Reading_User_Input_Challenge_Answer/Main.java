package s5p74_Reading_User_Input_Challenge_Answer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int sum = 0;

        /* While loop continues to iterate as long as counter < 10 is true.  */
        while(counter < 10) {
            int order = counter + 1;
            System.out.println("Enter number #" + order + ":");

            /* Checks if next input is int.  */
            boolean isAnInt = scanner.hasNextInt();

            /* If next input is int, increment counter by 1 and add number to sum.  */
            if (isAnInt) {
                int number = scanner.nextInt();
                counter++;
                sum += number;
            }
            /* Handles the error if input isn't int.  */
            else {
                System.out.println("Invalid number.  ");
            }
            scanner.nextLine();  // Handle end of line (Enter key).
        }

        System.out.println("sum = " + sum);

        scanner.close();
    }

}
