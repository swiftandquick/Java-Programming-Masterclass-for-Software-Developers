package s14p226_Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int x = 98;
        int y = 0;
        System.out.println(divideLBYL(x, y));
        System.out.println(divideEAFP(x, y));;
        /* Invoke method will result in error.  */
        // System.out.println(divide(x, y));

        x = getInt();
        System.out.println("x is " + x);

        x = getIntLBYL();
        System.out.println("x is " + x);

        x = getIntEAFP();
        System.out.println("x is " + x);
    }


    private static int getInt() {
        Scanner s = new Scanner(System.in);
        /* Return the input integer.  */
        return s.nextInt();
    }


    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer.  ");
        String input = s.next();
        for(int i = 0; i < input.length(); i++) {
            /* If the character at input’s (String) index i is not a digit...  */
            if(!Character.isDigit(input.charAt(i))) {
                /* If there is a non-number character, set isValid to false and break out of the loop.  */
                isValid = false;
                break;
            }
        }
        /* If isValid remains true, return the integer version of input (String).  */
        if(isValid) {
            return Integer.parseInt(input);
        }
        /* Return 0 if isValid is false.  */
        else {
            return 0;
        }
    }


    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer.  ");
        try {
            return s.nextInt();
        }
        /*  Return 0 if an InputMismatchException error is caught.
        InputMismatchException:  Token retrieved does not match the pattern for the expected type, or that the
        token is out of range for the expected type.  For example, my input is String when the method is nextInt().  */
        catch(InputMismatchException e) {
            return 0;
        }
    }


    private static int divideLBYL(int x, int y) {
        if(y != 0) {
            return x / y;
        }
        else {
            return 0;
        }
    }


    private static int divideEAFP(int x, int y) {
        /* try:  Allows me to define a block of code to be tested for errors while it is being executed.  */
        try {
            return x / y;
        }
        /* catch:  Allows me to define a block of code to be executed, if an error occurs in the try block.
        Execute the codes inside the catch block if ArithmeticException is caught in the try block.
        ArithmeticException is an unchecked exception in Java that occurs due to an exceptional arithmetic
        condition, such as divide by zero.  */
        catch(ArithmeticException e) {
            return 0;
        }
    }


    private static int divide(int x, int y) {
        return x / y;
    }

}
