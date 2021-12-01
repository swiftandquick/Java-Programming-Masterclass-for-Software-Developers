package s23_p390_Defining_Methods;

public class Methods {

    public static void main(String[] args) {

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("Your final score was " + highScore + ".  ");

        highScore = calculateScore(true, 10000, 8, 200);
        System.out.println("Your final score was " + highScore + ".  ");

    }


    public static int calculateScore(boolean isGameOver, int score, int levelCompleted, int bonus) {

        /* Checks if isGameOver's value is true.  */
        if (isGameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        }
        return -1;

    }

}
