package s9p131_Abstract_Classes_Part_2;

/* An abstract class inherit from another abstract class and implements CanFly interface.  */
public abstract class Bird extends Animal implements CanFly{

    public Bird(String name) {
        super(name);
    }


    @Override
    public void eat() {
        System.out.println(getName() + " is pecking.  ");
    }


    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat.  ");
    }


    /* Ovveride method from interface.  */
    @Override
    public void fly() {
        System.out.println(getName() + " is flapping its wings.  ");
    }

}
