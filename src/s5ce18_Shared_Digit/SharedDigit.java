package s5ce18_Shared_Digit;

public class SharedDigit {

    public static boolean hasSharedDigit(int a, int b) {
        if (a >= 10 && a <= 99 && b >= 10 && b <= 99) {

            /* Convert numbers to String.  */
            String aS = a + "";
            String bS = b + "";

            /* Get the first and last characters of the String aS (number a in String format).  */
            char aFirstChar = aS.charAt(0);
            char aSecondChar = aS.charAt(aS.length() - 1);

            /* indexOf returns -1 if the String does not contain the char, so if it does return -1, that means the
            * String contains the char.  Here, I am checking if the String bS (number b in String format) contains
            * the first character and last character of of the String aS (number a in String format).  */
            if (bS.indexOf(aFirstChar) != -1 || bS.indexOf(aSecondChar) != -1) {
                return true;
            }
            else {
                return false;
            }
        }

        else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(9, 99));
        System.out.println(hasSharedDigit(15, 55));
    }

}
