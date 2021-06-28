package s4p56_Coding_Exercises_Example_Part_2_Answer;

public class SpeedConverter {

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        else {
            return Math.round(kilometersPerHour * 0.621371);
        }
    }


    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid value.  ");
        }
        else {
            /* Call toMilesPerHour method, pass kilometersPerHour as argument.  */
            long milesPerHour = toMilesPerHour(kilometersPerHour);
            System.out.println(kilometersPerHour + " km/hr = " +
                    milesPerHour + " mi/hr");
        }
    }

}
