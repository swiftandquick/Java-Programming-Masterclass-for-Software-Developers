package s9p131_Abstract_Classes_Part_2;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }


    @Override
    public void fly() {
        super.fly(); // Call the fly() method in Bird class.
        System.out.println("I'm not very good at that, can I go for a swim instead?  ");
    }

}
