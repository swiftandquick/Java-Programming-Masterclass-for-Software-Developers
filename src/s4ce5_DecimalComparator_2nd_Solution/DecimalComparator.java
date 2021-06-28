package s4ce5_DecimalComparator_2nd_Solution;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {

        /* Use DecimalFormat class to round number to three decimal places.  */
        DecimalFormat rounding = new DecimalFormat("#.###");

        /* Set the rounding mode to round down, so -1.1111 is round to -1.111, and 1.1111 is round to 1.111.  */
        rounding.setRoundingMode(RoundingMode.DOWN);

        /* Round the double variables, returns a String.  */
        String aString = rounding.format(a);
        String bString = rounding.format(b);

        /* Check if the two new Strings are equal.  */
        if (aString.equals(bString)) {
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
