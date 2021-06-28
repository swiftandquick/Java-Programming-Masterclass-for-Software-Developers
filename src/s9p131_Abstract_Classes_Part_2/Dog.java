package s9p131_Abstract_Classes_Part_2;

/* Inherit from abstract class.  */
public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }


    /* I must override the abstract methods from abstract class.  */
    @Override
    public void eat() {
        System.out.println(getName() + " is eating.  ");
    }


    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat.  ");
    }

}
