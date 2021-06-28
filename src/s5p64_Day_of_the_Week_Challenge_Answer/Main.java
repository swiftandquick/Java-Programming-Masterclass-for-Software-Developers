package s5p64_Day_of_the_Week_Challenge_Answer;

public class Main {

    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }


    public static void main(String[] args) {
        printDayOfTheWeek(0);
        printDayOfTheWeek(4);
        printDayOfTheWeek(7);
    }

}
