package s5ce19_Last_Digit_Checker;

public class LastDigitChecker {

    public static boolean hasSameLastDigit(int a, int b, int c) {
        if (a >= 10 && a <= 1000 && b >= 10 && b <= 1000 && c >= 10 && c <= 1000) {
            /* Module of 10 to get the rightmost digit.  */
            if (a % 10 == b % 10 || a % 10 == c % 10 || b % 10 == c % 10) {
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


    public static boolean isValid(int number) {
        if (number >= 10 && number <= 1000) {
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));

        System.out.println(isValid(10));
        System.out.println(isValid(468));
        System.out.println(isValid(1051));
    }

}
