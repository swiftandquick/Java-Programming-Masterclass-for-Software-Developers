package s7p92_Composition_Part_2_Challenge_Exercise_Answer;

public class Main {

    public static void main(String[] args) {
        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedRoom = new Bedroom("Tims", wall1, wall2, wall3, wall4, ceiling, bed, lamp);

        /* Call makeBed() method, which then calls the make() method from Bed class.  */
        bedRoom.makeBed();

        /* Call the getLamp() method to return lamp, an instance of the Lamp object, then use it to call turnOn().  */
        bedRoom.getLamp().turnOn();
    }

}
