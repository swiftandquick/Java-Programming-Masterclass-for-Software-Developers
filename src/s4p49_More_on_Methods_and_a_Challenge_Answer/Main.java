package s4p49_More_on_Methods_and_a_Challenge_Answer;

public class Main {

    public static void main(String[] args) {

        displayHighScorePosition("Tim", calculateHighScorePosition(1100));
        displayHighScorePosition("Tom", calculateHighScorePosition(700));
        displayHighScorePosition("Jim", calculateHighScorePosition(250));
        displayHighScorePosition("Jane", calculateHighScorePosition(60));

    }


    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position
                        + " on the high score table.  ");
    }


    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) {
            return 1;
        }
        else if (score >= 500) {
            return 2;
        }
        else if (score >= 100) {
            return 3;
        }
        else {
            return 4;
        }
    }

}
