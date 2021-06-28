package s7p96_Polymorphism_Challenge_Exercise_Try;

public class Car {

    private String name;
    private int cylinders;
    private boolean engine;
    private int wheels;
    private double speed;


    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        engine = true;
        wheels = 4;
        speed = 0;
    }


    public String getName() {
        return name;
    }


    public int getCylinders() {
        return cylinders;
    }


    public boolean isEngine() {
        return engine;
    }


    public int getWheels() {
        return wheels;
    }


    public double getSpeed() {
        return speed;
    }


    public void startEngine() {
        System.out.println("The car starts engine.  ");
        engine = true;
    }


    public void stopEngine() {
        System.out.println("The car stops engine.  ");
        engine = false;
        speed = 0;
    }


    public void accelerate(int speedChange) {
        if (engine) {
            if (speed + speedChange >= 0) {
                speed = speed + speedChange;
            }
            else {
                System.out.println("The car's speed can't go below 0 km/hr.  ");
            }
        }
        else {
            System.out.println("Start the car's engine first.  ");
        }
    }


    public void brake() {
        if (engine) {
            System.out.println("Holds brake, the car's speed is reduce to 0 km/hr.  ");
            speed = 0;
        }
        else {
            System.out.println("Start the engine before using the brake.  ");
        }
    }


    public void move() {
        System.out.println("Zoom zoom zoom...  ");
    }

}
