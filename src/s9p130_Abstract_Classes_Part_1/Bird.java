package s9p130_Abstract_Classes_Part_1;

/* An abstract class inherit from another abstract class.  */
public abstract class Bird extends Animal {

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


    public abstract void fly();

}
