package s4p55_Coding_Exercises_Example_Part_1_Try;

public class SpeedConverter {

    public static long toMilesPerHour(long kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        else {
            return Math.round(kilometersPerHour/ 1.609);
        }
    }

    public static void main(String[] args) {

        System.out.println(toMilesPerHour(1));
        System.out.println(toMilesPerHour(2));
        System.out.println(toMilesPerHour(3));
        System.out.println(toMilesPerHour(4));
        System.out.println(toMilesPerHour(5));

    }

}
