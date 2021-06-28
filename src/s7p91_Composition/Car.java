package s7p91_Composition;

/* This is an inheritance relationship, not a composition relationship, because a Car is considered a Vehicle.  */
public class Car extends Vehicle {

    private int door;
    private int engineCapacity;

    public Car(String name, int door, int engineCapacity) {
        super(name);
        this.door = door;
        this.engineCapacity = engineCapacity;
    }
}
