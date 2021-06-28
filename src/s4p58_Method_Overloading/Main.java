package s4p58_Method_Overloading;

public class Main {

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }


    /* Method overloading, different argument list, same method name.  */
    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score * 1000;
    }


    public static void calculateScore() {
        System.out.println("No player name, no player score.");
    }

    public static void main(String[] args) {
        /* Call the calculateScore() method with (String, int) arguments.  */
        int newScore = calculateScore("Tim", 500);
        System.out.println("New score is " + newScore);

        /* Call the calculateScore() method with only (int) argument.  */
        calculateScore(75);

        /* Call the calculateScore() method with no arguments.  */
        calculateScore();
    }

}
