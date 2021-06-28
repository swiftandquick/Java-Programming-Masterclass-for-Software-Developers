package s3p36_Logical_and_Operator;

public class Main {

    public static void main(String[] args) {
        int topScore = 80;
        if (topScore < 100) {
            System.out.println("You got the high score!  ");
        }

        int secondTopScore = 60;
        /* Return true if topScore (80) > secondTopScore (60) and topScore (80) < 100.  */
        if (topScore > secondTopScore && topScore < 100) {
            System.out.println("Greater than second top score and less than 100.  ");
        }

        /* Returns true if topScore (80) > 90, which is false, or secondTopScore (60)
        * <= 90, which is true.  Only one of the two needs to be true to return true.  */
        if ((topScore > 90) || (secondTopScore <= 90)) {
            System.out.println("Either or both of the conditions are true.  ");
        }

        int newValue = 50;
        if (newValue == 50) {
            System.out.println("This is true");
        }

        boolean isCar = false;
        /* "==" is comparison, here, the program checks is isCar's value is true, which it isn't,
         * as I assign isCar to false above.  */
        if (isCar == true) {
            System.out.println("This is not supposed to happen #1.  ");
        }

        /* Executes the code block if isCar is not true, which means isCar is false.  */
        if (!isCar) {
            System.out.println("This is not supposed to happen #2.  ");
        }

        /* Sets isCar value to true, then checks isCar's value, which is true, then executes the
         code block below.  Note that "=" is an assignment operator.  */
        if (isCar = true) {
            System.out.println("This is not supposed to happen #3.  ");
        }

    }

}
