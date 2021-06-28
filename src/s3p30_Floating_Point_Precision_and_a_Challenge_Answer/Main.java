package s3p30_Floating_Point_Precision_and_a_Challenge_Answer;

public class Main {

    public static void main(String[] args) {
        double myPound = 20.5;
        double myKg = myPound * 0.45359237;

        System.out.println("Pound:  " + myPound);
        System.out.println("KG:  " + myKg);

        double pi = 3.4115927d;
        double anotherNumber = 3_000_000.456_789d;

        System.out.println(pi);
        System.out.println(anotherNumber);
    }

}
