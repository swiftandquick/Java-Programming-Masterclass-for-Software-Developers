package s12p156_Comparable_and_Comparator;

import java.util.*;

public class Main {

    /* Print out all Theatre.Seat objects in the list.  */
    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber() + " " + seat.getPrice());
        }
        System.out.println();
        System.out.println("====================================================");
    }


    public static void main(String[] args) {
        /* 8 rows ('A' to 'H') and 12 seats (01 to 12).  */
        Theatre theatre = new Theatre("Olympian", 8, 12);

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12.  ");
        }
        else {
            System.out.println("Seat already reserved.  ");
        }

        if(theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12.  ");
        }
        else {
            System.out.println("Seat already reserved.  ");
        }

        if(theatre.reserveSeat("B13")) {
            System.out.println("Please pay for D13.  ");
        }
        else {
            System.out.println("Seat already reserved.  ");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<Theatre.Seat>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceSeats = new ArrayList<Theatre.Seat>(theatre.getSeats());

        /* Add two new seats.  */
        priceSeats.add(theatre.new Seat("B00", 13.00));
        priceSeats.add(theatre.new Seat("A00", 13.00));

        /* I sort the list based on the return value of anonymous class that is declared inside the Comparator code
        block.  PRICE_ORDER is a Comparator object’s variable name. */
        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printList(priceSeats);
    }

}
