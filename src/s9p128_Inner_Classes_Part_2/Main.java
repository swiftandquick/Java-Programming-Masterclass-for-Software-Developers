package s9p128_Inner_Classes_Part_2;

public class Main {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);

        mcLaren.addGear(1, 5.3);
        mcLaren.addGear(2, 10.6);
        mcLaren.addGear(3, 15.9);
        mcLaren.operateClutch(true); // Set clutchIsIn to true.
        mcLaren.changeGear(1); // Since clutchIsIn is true, I can select Gear 1.
        mcLaren.operateClutch(false); // Set clutchIsIn to false.
        System.out.println(mcLaren.wheelSpeed(1000)); // clutchIsIn is currently false, return speed, 5.3 * 1000.
        mcLaren.changeGear(2); // clutIsIn is currently false, can't select gear 2, print Grind and set currentGear to 0.
        System.out.println(mcLaren.wheelSpeed(3000)); // Gear 0 has the ratio of 0, so returned speed is also 0.
        /* Same as gear 1, set clutchIsIn to true, select Gear 1, then set clutchIn to false.  */
        mcLaren.operateClutch(true);
        mcLaren.changeGear(3);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(6000)); // 15.9 * 6000 = 95400
    }

}
