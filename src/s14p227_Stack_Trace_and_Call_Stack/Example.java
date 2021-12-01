package s14p227_Stack_Trace_and_Call_Stack;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        }
        /* Catching multiple types of exception.  If either ArithmeticException or NoSuchElementException is caught
        * in the try block, the codes inside the catch block is executed.  */
        catch(ArithmeticException | NoSuchElementException e) {
            System.out.println(e.toString());
            System.out.println("Unable to perform division, autopilot shutting down.  ");
        }
    }


    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x is " + x + ", y is " + y);
            return x / y;
        }
        /* This is only useful if getInt() method didn't force us to keep inputing until s is an int.
        * Catch NoSuchElementException, throw new ArithmeticException with the text "No Suitable input.  "
        * NoSuchElementException:  The element being requested does not exist.  */
        catch(NoSuchElementException e) {
            throw new ArithmeticException("No Suitable input.  ");
        }
        catch (ArithmeticException e) {
            /* Catch NoSuchElementException, throw new ArithmeticException with the text "Attempt to divide by zero.  "*/
            throw new ArithmeticException("Attempt to divide by zero.  ");
        }
    }


    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer.  ");
        while(true) {
            try {
                return s.nextInt();
            }
            /* If input is not int...  */
            catch(InputMismatchException e) {
                /* Iterate the while loop again, while loop stops until an int is the input.  */
                s.nextLine();
                System.out.println("Please enter a number using only digits 0 to 9.  ");
            }
        }
    }

}
