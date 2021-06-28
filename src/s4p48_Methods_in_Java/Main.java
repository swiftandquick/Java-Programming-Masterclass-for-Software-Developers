package s4p48_Methods_in_Java;

public class Main {

    public static void main(String[] args) {
        /* Pass in boolean, int, int, int as arguments.  The arguments that we are passing
        * match the parameters we've defined for the method.  */
        calculateScore(true, 800, 5, 100);

        // Call the calculateScore method again.
        calculateScore(true, 10000, 8, 200);
    }


    /* Method is type void, which returns nothing.  */
    public static void calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver == true) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }

}