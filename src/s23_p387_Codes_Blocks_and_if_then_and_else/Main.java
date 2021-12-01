package s23_p387_Codes_Blocks_and_if_then_and_else;

public class Main {

    public static void main(String[] args) {
        int score = 5000;
        /* if statement without code blocks.  */
        if (score == 5000)
            System.out.println("You got the high score.  ");
        System.out.println("This was executed.  ");

        score = 800;
        /* if-else statements with code blocks.  */
        if ((score < 5000) && (score > 1000)) {
            System.out.println("Your score was less than 5000 but greater than 1000.  ");
        }
        else if (score <= 1000) {
            System.out.println("Your score was less than or equal to 1000.  ");
        }
        else {
            System.out.println("Got here.  ");
        }

        boolean isGameOver = true;
        int levelCompleted = 5;
        int bonus = 100;

        /* Checks if isGameOver's value is true.  */
        if (isGameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your final score was " + finalScore + ".  ");
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (isGameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore + ".  ");
        }

    }

}
