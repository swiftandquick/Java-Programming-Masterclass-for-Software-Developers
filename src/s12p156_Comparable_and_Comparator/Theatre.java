package s12p156_Comparable_and_Comparator;

import java.util.*;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();


    /* I can use Comparator to sort the list base on an attribute of the object, in this case, price.  */
    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        /* Override the compare() method and use it to sort seats based on price from lowest to highest.  */
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()) {
                return -1;
            }
            else if(seat1.getPrice() > seat2.getPrice()) {
                return 1;
            }
            else {
                return 0;
            }
        }
    };


    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows - 1);
        /* char type can be incremented, so 'A' + 1 = 'B'.  Get the seat in String format, then call the Seat
        * constructor to create a new Seat object, add the Seat object to seats List.  */
        for(char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price;
                /* Seats in the middle of first three rows cost $14.  */
                if((row < 'D') && (seatNum >= 4 && seatNum <= 9)) {
                    price = 14.00;
                }
                /* Seats in the back or on the edge cost $7.  */
                else if ((row > 'F') || (seatNum < 4 || seatNum > 9)) {
                    price = 7.00;
                }
                /* All other seats cost $12.  */
                else {
                    price = 12.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }


    public String getTheatreName() {
        return theatreName;
    }


    public boolean reserveSeat(String seatNumber) {
        /* Use seatNumber as a String to create a new Seat object requestedSeat.  */
        Seat requestedSeat = new Seat(seatNumber, 0);
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


    /* Getter for seats.  */
    public Collection<Seat> getSeats() {
        return seats;
    }


    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private double price;
        /* reserved is initially false, call reserve method can change that.  */
        private boolean reserved = false;

        /* Set the Seat number, constructor of Theatre sets a list of Seat objects.  */
        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getPrice() {
            return price;
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
