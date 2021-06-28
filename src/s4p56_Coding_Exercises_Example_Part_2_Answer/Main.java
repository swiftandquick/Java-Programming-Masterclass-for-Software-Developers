package s4p56_Coding_Exercises_Example_Part_2_Answer;

public class Main {

    public static void main(String[] args) {
        /* Call the toMilesPerHour() method from SpeedConverter.java class.
         * Passes 10.5 as argument.  Returns a value.  */
        double miles = s4p55_Coding_Exercises_Example_Part_1_Answer.SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + miles);

        /* Calls the printConversion() method from SpeedConverter.java class.  */
        SpeedConverter.printConversion(10.5);
    }

}
