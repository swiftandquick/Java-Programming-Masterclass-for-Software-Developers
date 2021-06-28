package s6p88_Inheritance_Challenge_Try;

public class Vehicle {

    private int wheels;
    private int speed;
    private String gears;


    public Vehicle(int wheels, int speed, String gears) {
        this.wheels = wheels;
        if (speed >= 0) {
            this.speed = speed;
        }
        else {
            this.speed = 0;
        }
        this.gears = gears;
    }


    public int getSpeed() {
        return speed;
    }


    public void printWheels() {
        System.out.println("# of wheels:  " + wheels);
    }


    public void printGears() {
        System.out.println("# of gears:  " + gears);
    }


    public void changeGears(String gears) {
        this.gears = gears;
    }


    public void speedChange(int speedChange) {
        if (speedChange + speed >= 0) {
            speed = speed + speedChange;
        }
        else {
            speed = 0;
        }
    }


    public void steering() {
        System.out.println("The vehicle is steering at the speed of " + speed + "km/hr.  ");
    }

}
