package s6p87_Static_VS_Instance_Variables_b;

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("name = " + name);
    }

}


public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("rex"); // Creates instance (rex).
        Dog fluffy = new Dog("fluffy"); // Creates instance (fluffy).

        /* Prints different names this time around because I use instance variables.  Each instance of the class
        * has its own state or own values.  */

        rex.printName(); // Prints rex.
        fluffy.printName(); // Prints fluffy.
    }

}