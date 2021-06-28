package s4p44_Keywords_and_Expressions;

public class Main {

    public static void main(String[] args) {
        /* Expression is "kilometers = 100 * 1.609344".  */
        double kilometers = 100 * 1.609344;
        int highScore = 50;

        /* Expression is highScore == 50.  */
        if (highScore == 50) {
            System.out.println("This is an expression.  ");
        }

        // "score = 100" is an expression.
        int score = 100;
        // "score > 99" is an expression.
        if (score > 99) {
            /* "You got the high score!  " is an expression.  */
            System.out.println("You got the high score!  ");
            /* "score = 0" is an expression.  */
            score = 0;
        }
    }

}
