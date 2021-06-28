package s7p96_Polymorphism_Challenge_Exercise_Try;

public class Main {

    public static void main(String[] args) {

        /* Polymorphism, create the Vehicle type object car, then store the Car object in car.  */
        Car toyota = new Toyota(6);

        /* Use car (Vehicle type object) to invoke the move() method in the Car class, which overrides the move()
        method from the Vehicle class.  */
        toyota.move();

        /* Use car (Vehicle type object) to invoke various methods from the Vehicle class.  */

        /* Stop engine, so I can't accelerate or use brake.  */
        toyota.stopEngine();
        toyota.accelerate(50);
        toyota.brake();

        /* Start the engine.  */
        toyota.startEngine();
        System.out.println("Speed:  " + toyota.getSpeed() + " km/hr");
        toyota.accelerate(-50); // Speed can't go below 0.
        System.out.println("Speed:  " + toyota.getSpeed() + " km/hr");
        toyota.accelerate(25); // Increase speed from 0 to 25.
        System.out.println("Speed:  " + toyota.getSpeed() + " km/hr");

        /* Hold the brake, speed decreases to 0 km/hr.  */
        toyota.brake();
        System.out.println("Speed:  " + toyota.getSpeed() + " km/hr");

        /* Use polymorphism for other two Car subclasses.  */
        Car mercedes = new Mercedes(4);
        mercedes.move();
        Car tesla = new Tesla(8);
        tesla.move();

    }

}
