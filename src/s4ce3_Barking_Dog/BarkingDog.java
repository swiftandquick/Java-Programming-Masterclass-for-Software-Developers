package s4ce3_Barking_Dog;

public class BarkingDog {

    public static boolean shouldWakeUp(boolean bark, int hourOfDay) {
        if (!bark || hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }
        else {
            if (hourOfDay < 8 || hourOfDay > 22) {
                return true;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 1));
        System.out.println(shouldWakeUp(false, 2));
        System.out.println(shouldWakeUp(true, 8));
        System.out.println(shouldWakeUp(true, -1));
    }

}
