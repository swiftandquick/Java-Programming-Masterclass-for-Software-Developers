package s6p88_Inheritance_Challenge_Try;

public class Toyota extends Car {

    /* All Toyota have 4 wheels.  */
    public Toyota(int speed, String gears) {
        super(4, speed, gears);
    }


    @Override
    public void steering() {
        System.out.println("The Toyota is steering at the speed of " + getSpeed() + "km/hr.  ");
    }

}
