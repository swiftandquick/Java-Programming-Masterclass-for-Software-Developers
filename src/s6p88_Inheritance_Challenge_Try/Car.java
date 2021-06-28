package s6p88_Inheritance_Challenge_Try;

public class Car extends Vehicle {

    public Car(int wheels, int speed, String gears) {
        super(wheels, speed, gears);
    }


    @Override
    public void steering() {
        System.out.println("The car is steering at the speed of " + getSpeed() + "km/hr.  ");
    }

}
