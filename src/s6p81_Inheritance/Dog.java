package s6p81_Inheritance;

/* Dog is a subclass of Animal.  */
public class Dog extends Animal {

    /* Dog class inherits 5 instance variables from Animal, and Dog class
    * has additional unique instance variables.  */
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;


    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        /* Call the superclass' (Animal) constructor.  */
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }


    private void chew() {
        System.out.println("Dog.chew() is called.  ");
    }


    /** Override the eat() method from the Animal class.  */
    @Override
    public void eat() {
        System.out.println("Dog.eat() called.  ");
        chew();
        /* Call the superclass' eat() method.  */
        super.eat();
    }


    public void walk() {
        System.out.println("Dog.walk() called.");
        /* Call the move() method in Animal class, pass 5 as argument.  */
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.run() called.");
        /* Call the move() method in Dog class, pass 10 as argument.  */
        move(10);
    }


    public void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }


    /* Overrides the move() method from Animal class.  */
    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        /* Call the move() method in Animal class.  */
        super.move(speed);
    }


}
