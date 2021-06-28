package s9p131_Abstract_Classes_Part_2;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        /* I cannot instantiate abstract class.  */
        // Bird bird = new Bird("Parrot");
        Parrot parrot = new Parrot("Australian Ringneck");
        /* Since Parrot is a subclass of Bird, the object parrot gain access to Bird class methods as well.  */
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }

}
