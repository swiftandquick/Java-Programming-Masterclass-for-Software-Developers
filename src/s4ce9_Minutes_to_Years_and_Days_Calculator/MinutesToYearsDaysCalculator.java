package s4ce9_Minutes_to_Years_and_Days_Calculator;

public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        }
        else {
            long days = minutes / 1440;
            long years = days / 365;
            long remainingDays = days % 365;
            System.out.printf("%d min = %d y and %d d\n", minutes, years, remainingDays);
        }
    }


    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

}
