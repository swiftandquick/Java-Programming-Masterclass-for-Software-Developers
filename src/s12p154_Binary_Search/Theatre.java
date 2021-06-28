package s12p154_Binary_Search;

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
        /* Use seatNumber as a String to create a new Seat object requestedSeat.  */
        Seat requestedSeat = new Seat(seatNumber);
        /* Try to check if the requestedSeat is in the seats List with binarySearch() method.  */
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        /* binarySearch() returns an index (positive number) if object exists in the list.  */
        if (foundSeat >= 0) {
            /* use seat to call the reserve method in the Seat class to check if the Seat is reserved
             * or not, if it's not currently reserved, return true, otherwise return false.  */
            return seats.get(foundSeat).reserve();
        }
        else {
            System.out.println("There is no seat " + seatNumber + ".  ");
            return false;
        }
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
