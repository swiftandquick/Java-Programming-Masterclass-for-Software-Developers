package s12p154_Binary_Search;

public class Main {

    public static void main(String[] args) {
        /* 8 rows ('A' to 'H') and 12 seats (01 to 12).  */
        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();

        /* Because H11 is part of the Seat object in seats list, and each Seat object's reserved variable is initially
        * false, reserveSeat() method initially returns true and set H11's reserved variable to false.  */
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay.  ");
        }
        else {
            System.out.println("Sorry, seat is taken.  ");
        }

        /* H11's reserve value is now true, that means reserveSeat() returns false.  */
        if (theatre.reserveSeat("H11")) {
            System.out.println("Please pay.  ");
        }
        else {
            System.out.println("Sorry, seat is taken.  ");
        }
    }

}
