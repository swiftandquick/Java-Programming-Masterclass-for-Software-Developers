package s9p130_Abstract_Classes_Part_1;

/* Inherit from the abstract class Bird.  */
public class Parrot extends Bird {

    public Parrot(String name) {
        super(name);
    }


    @Override
    public void fly() {
        System.out.println("Flitting from branch to branch.  ");
    }

}
