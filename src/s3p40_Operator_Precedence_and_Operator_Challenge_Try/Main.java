package s3p40_Operator_Precedence_and_Operator_Challenge_Try;

public class Main {

    public static void main(String[] args) {
        double var1 = 20.00;
        double var2 = 80.00;

        double result = (var1 + var2) * 100.00;

        double remainder = result % 40.00;

        System.out.println(remainder);
    }

}
