package s4p56_Coding_Exercises_Example_Part_2_Try;

public class SpeedConverter {

    public static void printConversion(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        }
        else {
            double milesPerHour = kilometersPerHour * 1.609;
            System.out.printf("%.2f km/h = %.2f mi/h\n", kilometersPerHour, milesPerHour);
        }
    }

    public static void main(String[] args) {
        printConversion(-1);
        printConversion(1);
        printConversion(2);
        printConversion(3);
        printConversion(4);
        printConversion(5);
    }

}
