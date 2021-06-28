package s4p46_Code_Blocks_and_the_if_then_else_Control_Statements;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        /* Checks if score (5000) < 5000 and score > 1000, which is false.  */
        if (score < 5000 && score > 1000) {
            System.out.println("Your score was less 5000 but greater than 1000");
        }
        /* Since if statement is false, now program needs to check the else-if's
        * conditional statement, which is if score (5000) < 1000, which is also false.  */
        else if (score < 1000) {
            System.out.println("Your score was less than 1000");
        }
        /* Since both if and else if are false, execute the code inside the else block.  */
        else {
            System.out.println("Got here.  ");
        }


        /* Executes the code block below because gameOver is true.  */
        if (gameOver == true) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        boolean newGameOver = true;
        int newScore = 10000;
        int newLevelCompleted = 8;
        int newBonus = 200;

        if (newGameOver) {
            int finalScore = newScore + (newLevelCompleted * newBonus);
            System.out.println("Your final scorre was " + finalScore);
        }

    }

}
