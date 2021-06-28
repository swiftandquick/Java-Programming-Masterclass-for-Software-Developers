package s9p128_Inner_Classes_Part_2;

import java.util.ArrayList;

public class Gearbox {

    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0; // Current gear is initially set as 0, but it can change.
    private boolean clutchIsIn;


    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<Gear>();
        /* When Gearbox object is instantiated, Gearbox instantiate Gear 0, with ratio of 0.  */
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);

        /* Instanitate all Gear objects inside the gears ArrayList.  Gear 1 ratio = 5.3,  gear 2 ratio = 10.6...  */
        for(int i = 0; i < maxGears; i++) {
            addGear(i, i * 5.3);
        }
    }


    public void operateClutch(boolean in) {
        clutchIsIn = in;
    }


    /* 0th gear is already occupied and gear number can't be above maxGears, so if the number is between 1 and
    * maxGears, add the gear to gears ArrayList.  */
    public void addGear(int number, double ratio) {
        if((number > 0) && (number <= maxGears)) {
            gears.add(new Gear(number, ratio));
        }
    }


    /* If clutchIsIn is true, newGear is between 0 and size of gears minus 1, set currentGear to new gear.  */
    public void changeGear(int newGear) {
        if((newGear >= 0) && (newGear < gears.size()) && clutchIsIn) {
            currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.  ");
        }
        else {
            System.out.println("Grind!  ");
            currentGear = 0;
        }
    }


    /* Return speed if clutchIsIn is false.  */
    public double wheelSpeed(int revs) {
        if(clutchIsIn) {
            System.out.println("Scream!  ");
            return 0.0;
        }
        else {
            /* gears:  ArrayList that contains a list of objects <Gear>.
            gears.get(currentGear):  Returns an object of Gear type from the ArrayList.
            getRatio():  Method from inner class Gear.  */
            return revs * gears.get(currentGear).getRatio();
        }
    }


    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double getRatio() {
            return ratio;
        }

    }

}
