package s5ce18_Shared_Digit_b;

public class SharedDigit {

    public static boolean hasSharedDigit(int a, int b) {
        if (a >= 10 && a <= 99 && b >= 10 && b <= 99) {

            /* Use division to get first digit, use modulo the get last digit.  */
            int firstA = a / 10;
            int lastA = a % 10;
            int firstB = b / 10;
            int lastB = b % 10;

            /* If any digit of A equal to any digit of B, return true.  */
            if (firstA == firstB || firstA == lastB || lastA == firstB || lastA == lastB) {
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
