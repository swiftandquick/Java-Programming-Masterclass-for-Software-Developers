package s4p58_Method_Overloading_b;

public class Main {

    /* Calculate cm using ft and in.  */
    public static double calcFeetAndInchesToCentimeters(int feet, int inches) {
        if (feet >= 0 && (inches >= 0 && inches <= 12)) {
            return feet * 30.48 + inches * 2.54;
        }
        else {
            return -1;
        }
    }

    /* Calculate cm using in only.  */
    public static double calcFeetAndInchesToCentimeters(int inches) {
        if (inches >= 0) {
            return inches * 2.54;
        }
        else {
            return -1;
        }
    }


    public static void main(String[] args) {
        System.out.println(calcFeetAndInchesToCentimeters(4, 5));
        System.out.println(calcFeetAndInchesToCentimeters(44));
    }

}
