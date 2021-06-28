package s4p54_Coding_Exercises_Answer;

public class positiveNegativeZero {

    public static void main(String[] args) {
        checkNumber(-1);
        checkNumber(1);
        checkNumber(0);
    }


    public static void checkNumber(int number) {
        if (number > 0) {
            System.out.println("positive");
        }
        else if (number < 0) {
            System.out.println("negative");
        }
        else {
            System.out.println("zero");
        }
    }

}
