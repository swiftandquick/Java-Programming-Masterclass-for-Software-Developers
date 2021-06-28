package s9p127_Inner_Classes_Part_1;

public class Main {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);

        /* Gear is inside Gearbox class, so in order to create a new Gear, I have to put Gearbox in front of Gear.
        * Then, I instantiate a new Gear object in the Gearbox mcLaren object.  */
        Gearbox.Gear first = mcLaren.new Gear(1, 12.3);

        /* Because Gear is not a static class, I can't use Gearbox class to call it.  */
        // Gearbox.Gear second = new Gearbox.Gear(2, 15.4);

        /* I am creating a new object of Gear, so new needs to be before Gear but after the Gearbox object (mcLaren).  */
        // Gearbox.Gear third = new mcLaren.Gear(3, 17.8);

        System.out.println(first.driveSpeed(1000)); // Prints out 12300.0
    }

}
