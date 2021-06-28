package s6p88_Inheritance_Challenge_Try;

public class Main {

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(18, 60, "18-Wheeler Gears");
        v1.printGears();
        v1.printWheels();
        v1.steering();

        Car v2 = new Car(6, 45, "Gear Box 1.0");
        v2.printGears();
        v2.changeGears("Gear Box 3.0"); // Call changeGears method to change the value of gears.
        v2.printGears();
        v2.printWheels();
        v2.steering();

        Toyota v3 = new Toyota(50, "Gear Box 2.0");
        v3.printGears();
        v3.printWheels();
        v3.steering();
        v3.speedChange(20); // Faster.
        v3.steering();
        v3.speedChange(-15); // Slower.
        v3.steering();
    }

}
