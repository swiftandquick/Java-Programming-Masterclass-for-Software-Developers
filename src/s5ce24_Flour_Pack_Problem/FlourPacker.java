package s5ce24_Flour_Pack_Problem;

public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        /* If goal is greater than the combine amount from big bags and small bags, return false.  */
        else if (goal > ((bigCount * 5) + smallCount)) {
            return false;
        }
        /* If the remainder of goal is greater than number of small bags, return false.  For example (2, 1, 7).
        * 7 % 5 = 2, 2 > 1, return false.  A big bag is 5 kg, and the small bag is 1 kg, in total it's 6 kg, 6 < 7.  */
        else if ((goal % 5) > smallCount) {
            return false;
        }
        else {
            return true;
        }
    }


    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));
        System.out.println(canPack(2, 1, 5));
        System.out.println(canPack(2, 1, 7));
    }

}
