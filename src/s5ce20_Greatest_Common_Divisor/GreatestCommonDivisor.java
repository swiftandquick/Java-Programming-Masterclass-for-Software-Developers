package s5ce20_Greatest_Common_Divisor;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int a, int b) {
        if (a < 10 || b < 10) {
            return -1;
        }
        else {
            int gcd = 1;
            if (a >= b) {
                for (int i = 1; i <= b; i++) {
                    if (a % i == 0 && b % i == 0) {
                        gcd = i;
                    }
                }
            }
            else {
                for (int i = 1; i <= a; i++) {
                    if (a % i == 0 && b % i == 0) {
                        gcd = i;
                    }
                }
            }
            return gcd;
        }
    }


    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }

}
