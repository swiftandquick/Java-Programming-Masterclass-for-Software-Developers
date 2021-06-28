package s4p48_Methods_in_Java_b;

public class Main {

    public static void main(String[] args) {
        /* Pass in boolean, int, int, int as arguments.  The arguments that we are passing
         * match the parameters we've defined for the method.  */
        int finalScore1 = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + finalScore1);

        // Call the calculateScore method again.
        int finalScore2 = calculateScore(true, 10000, 8, 200);
        System.out.println("Your final score was " + finalScore2);
    }


    /* Method is type int, which returns an int.  */
    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
        if (gameOver == true) {
            int finalScore = score + (levelCompleted * bonus);
            return finalScore;
        }
        else {
            return 0;
        }
    }

}
