package s5ce14_Sum_Odd;

public class SumOddRange {

    public static boolean isOdd(int number) {
        if (number > 0) {
            if (number % 2 == 1) {
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


    public static int sumOdd(int start, int end) {

        if ((end >= start) && (start > 0) && (end > 0)) {
            int sum = 0;
            for (int n = start; n <= end; n++) {
                if (isOdd(n)) {
                    sum = sum + n;
                }
            }
            return sum;
        }
        else {
            return -1;
        }

    }


    public static void main(String[] args) {
        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
        System.out.println(sumOdd(100, -100));
        System.out.println(sumOdd(100, 1000));
    }

}
