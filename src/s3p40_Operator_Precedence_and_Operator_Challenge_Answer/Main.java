package s3p40_Operator_Precedence_and_Operator_Challenge_Answer;

public class Main {

    public static void main(String[] args) {
        double var1 = 20.00;
        double var2 = 80.00;

        double result = (20.00 + 80.00) * 100.00 % 40;

        boolean bool = result == 0 ? true : false;
        System.out.println(bool);

        if (!bool) {
            System.out.println("Got some remainder.  ");
        }
    }

}
