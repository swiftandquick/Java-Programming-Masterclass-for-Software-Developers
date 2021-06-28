package s12p154_Binary_Search_b;

import java.util.*;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();


    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        /* char type can be incremented, so 'A' + 1 = 'B'.  Get the seat in String format, then call the Seat
        * constructor to create a new Seat object, add the Seat object to seats List.  */
        for(char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }


    public String getTheatreName() {
        return theatreName;
    }


    public boolean reserveSeat(String seatNumber) {
        int low = 0; // Lowest index.
        int high = seats.size() - 1; // Highest index, which is 95 in our case.

        while (low <= high) {
            /* Binary search is faster than part 153's search method, as I can see, there are less dot printed.  */
            System.out.print(".");
            /* Get the middle index.  First iteration, mid = 47.  Second iteration, mid = 71 if cmp < 0, mid = 23
            if cmp > 0.  And so on...  */
            int mid = (low + high) / 2;
            /* Get the middle index's value, compare middle index's value seatNumber to seatNumber.  */
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            /* If cmp is a negative number, means midVal's seatNumber is alphabetically before parameter's seatNumber,
            * then, I set low to mid + 1, which means low is now 48.  In the next while loop iteration, I check the
            * middle index in the upper half (index 48 to index 95) of the list.   */
            if (cmp < 0) {
                low = mid + 1;
            }
            /* If cmp is a positive number, means midVal's seatNumber is alphabetically after parameter's seatNumber,
             * then, I set high to mid - 1, which means high is now 46.  In the next while loop iteration, I check the
             * middle index in the lower half (index 0 to index 46) of the list.   */
            else if (cmp > 0) {
                high = mid - 1;
            }
            /* If cmp = 0, means that the seat is found, so I call the reserve method to see if it's already reserved.  */
            else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber + ".  ");
        return false;
    }


    /* Print out all the seats.  */
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }


    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        /* reserved is initially false, call reserve method can change that.  */
        private boolean reserved = false;

        /* Set the Seat number, constructor of Theatre sets a list of Seat objects.  */
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        /* Overrides compareTo method, returns 0 if two String are equal, a positive number if this object's seatNumber
         value is alphabetically after seat's seatNumber value, otherwise, return a negative number.  compareTo method
         sort seats alphabetically, and its sorting order affects what binarySearch() method returns.  */
        @Override
        public int compareTo(Seat seat) {
            return seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        /* If seat is not reserved yet, reserve it, and it will be reserved next time.  */
        public boolean reserve() {
            if(!reserved) {
                reserved = true;
                System.out.println("Seat " + seatNumber + " is reserved.  ");
                return true; // Successfully reserve a vacant seat.
            }
            else {
                return false; // Fail to reserve a vacant seat.
            }
        }

        /* Cancel the reserved seats by setting reserved to false if it's initially true.  */
        public boolean cancel() {
            if(reserved) {
                reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled.  ");
                return true; // Successfully cancel a reservation.
            }
            else {
                return false; // Fail to cancel a reservation.
            }
        }
    }

}
