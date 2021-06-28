package s4ce5_DecimalComparator;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {

        double a2 = a * 1000;
        double b2 = b * 1000;

        /* Cast double to int to get rid of remaining decimal digits.  */
        int a3 = (int) a2;
        int b3 = (int) b2;

        if (a3 == b3) {
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(-3.175, -3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
    }

}
