package s4p54_Coding_Exercises_Try;

public class Main {

    public static void checkNumber(int n) {

        if (n > 0) {
            System.out.println("positive");
        }
        else if (n < 0) {
            System.out.println("negative");
        }
        else if (n == 0){
            System.out.println("zero");
        }

    }


    public static void main(String[] args) {
        checkNumber(-5);
        checkNumber(5);
        checkNumber(0);
    }

}
