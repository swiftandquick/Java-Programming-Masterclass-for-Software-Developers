package s4p60_Seconds_and_Minutes_Challenge_Answer;

public class Main {

    public static String getDurationString(int minutes, int seconds) {
        if (minutes >= 0 && (seconds >= 0 && seconds <=59)) {
            int hours = minutes / 60;
            int newMinutes = minutes % 60;
            return hours + "h " + newMinutes + "m " + seconds + "s";
        }
        else {
            return "Invalid value";
        }
    }


    public static String getDurationString(int seconds) {
        if (seconds >= 0) {
            int hours = seconds / 3600;
            int minutes = (seconds - hours * 3600) / 60;
            int newSeconds = seconds - (hours * 3600) - (minutes * 60);
            return hours + "h " + minutes + "m " + newSeconds + "s";
        }
        else {
            return "Invalid value";
        }
    }


    public static void main(String[] args) {
        System.out.println(getDurationString(90, 50));
        System.out.println(getDurationString(5450));
    }

}
