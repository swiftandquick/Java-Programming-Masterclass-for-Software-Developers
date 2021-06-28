package s5p71_Reading_User_Input;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth:  ");

        /* Checks if next input entered is an int.  */
        boolean hasNextInt = scanner.hasNextInt();

        if (hasNextInt) {
            /* ASks for an int input.  */
            int yearOfBirth = scanner.nextInt();
            int age = 2020 - yearOfBirth;

            /* Call nextLine() method but assign nothing to it.  */
            scanner.nextLine();

            System.out.println("Enter your name:  ");
            /* Asks for a String input.  */
            String name = scanner.nextLine();

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ", and you are " + age + " years old.  ");
            } else {
                System.out.println("Invalid year of birth.  ");
            }
        }
        /* If input is not int type, execute the code block below.  */
        else {
            System.out.println("Unable to parse year of birth.  ");
        }

        /* Close the scanner.  */
        scanner.close();
    }

}
