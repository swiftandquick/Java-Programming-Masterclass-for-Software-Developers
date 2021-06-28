package s4p60_Seconds_and_Minutes_Challenge_Try;

public class Main {

    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && seconds >= 0 && seconds <= 59) {
            int hours = minutes / 60;
            int newMinutes = minutes % 60;
            return hours + "h " + newMinutes + "m " + seconds + "s";
        }
        else {
            return "Invalid Value";
        }
    }


    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int newSeconds = seconds % 60;
            int minutes = seconds / 60;
            return getDurationString(minutes, newSeconds);
        }
        else {
            return "Invalid Value";
        }
    }


    public static void main(String[] args) {
        System.out.println(getDurationString(5, 20));
        System.out.println(getDurationString(-1, 0));
        System.out.println(getDurationString(2, 60));
        System.out.println(getDurationString(320, 50));

        System.out.println(getDurationString(-5));
        System.out.println(getDurationString(330));
        System.out.println(getDurationString(4550));
    }

}
