package s4p55_Coding_Exercises_Example_Part_1_Answer;

public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        else {
            return Math.round(kilometersPerHour * 0.621371);
        }
    }

}
