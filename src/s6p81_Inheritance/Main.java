package s6p81_Inheritance;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 5, 5);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");

        /* Calls the eat() method from Dog class.  */
        dog.eat();

        dog.walk();

        dog.run();
    }

}
