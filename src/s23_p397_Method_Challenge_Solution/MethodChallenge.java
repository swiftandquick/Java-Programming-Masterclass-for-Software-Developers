package s23_p397_Method_Challenge_Solution;

public class MethodChallenge {

    public static void main(String[] args) {

        int playerScore = calculateHighScorePosition(1500);
        displayHighScorePosition("Tim", playerScore);

        displayHighScorePosition("Tim", calculateHighScorePosition(900));

        displayHighScorePosition("Tim", calculateHighScorePosition(400));

        displayHighScorePosition("Tim", calculateHighScorePosition(50));

        displayHighScorePosition("Louise", calculateHighScorePosition(1000));

    }


    public static void displayHighScorePosition(String playerName, int position) {

        System.out.println(playerName + " managed to get to position "
                + position + " on the high score table.");
    }


    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        }
        else if(score >= 500 && score < 1000) {
            return 2;
        }
        else if(score >= 100 && score < 500) {
            return 3;
        }
        return 4;
    }

}
