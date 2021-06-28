package s12p155_Collections_List_Methods;

import java.util.*;

public class Main {

    /* Print out all Theatre.Seat objects in the list.  */
    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("====================================================");
    }


    /* ? is a generic type, extends upper bound to Theatre.Seat means it only accepts Theatre.Seat objects.
    * Bubble sort, compare index 0 to index 1, if index 1 is greater, swap index 0 and index 1, now index 1 has the
    * value of index 0, now compare index 1 with new value to index 2, and so on.  */
    public static void sortList(List<? extends Theatre.Seat> list) {
        /* Compare each item to the next items.  */
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                /* if this i's seatNumber value is alphabetically after j's seatNumber value, swap i and j's position.  */
                if(list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        /* 8 rows ('A' to 'H') and 12 seats (01 to 12).  */
        Theatre theatre = new Theatre("Olympian", 8, 12);

        /* Set seatCopy, a List equal to the seats list.  */
        List<Theatre.Seat> seatCopy = new ArrayList<Theatre.Seat>(theatre.seats);
        printList(seatCopy);

        /* Index 1 is seat with seatNumber "A02".  */
        seatCopy.get(1).reserve();
        /* I already reserve "A02", so reserveSeat will return false this time.  */
        if(theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02.  ");
        }
        else {
            System.out.println("Seat already reserved.  ");
        }

        /* Reverse the list order.  */
        Collections.reverse(seatCopy);
        System.out.println("Printing seatCopy.  ");
        printList(seatCopy);
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy.  ");
        printList(seatCopy);
        System.out.println("Printing theatre.seat.  ");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        /* Get the lowest indexed item on a sorted list (base on compareTo() method).  */
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        /* Get the highest indexed item on a sorted list (base on compareTo() method).  */
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        /* Use bubble sort to sort the list seatCopy to sort a randomized list back to alphabetical order.  */
        sortList(seatCopy);
        System.out.println("Printing seatCopy.  ");
        printList(seatCopy);

        /* This only sets capacity of the ArrayList, giving it the potential to hold that many elements but initially
        * containing none.  So it doesn't actually create a number of elements.  */
        List<Theatre.Seat> newList = new ArrayList<Theatre.Seat>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
    }

}
