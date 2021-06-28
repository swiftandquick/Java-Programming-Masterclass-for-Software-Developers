package s4p49_More_on_Methods_and_a_Challenge_Try;

public class Main {

    public static int Score(int score) {
        if (score > 1000) {
            return 1;
        }
        else if (score > 500 && score < 1000) {
            return 2;
        }
        else if (score > 100 && score < 500) {
            return 3;
        }
        else {
            return 4;
        }
    }


    public static void main(String[] args) {
        System.out.println(Score(50));
        System.out.println(Score(250));
        System.out.println(Score(750));
        System.out.println(Score(1000));
        System.out.println(Score(1250));
    }

}
