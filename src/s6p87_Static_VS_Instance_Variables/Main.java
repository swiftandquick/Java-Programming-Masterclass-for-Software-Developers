package s6p87_Static_VS_Instance_Variables;

class Dog {

    /* name is a static variable.  */
    private static String name;

    public Dog(String name) {
        Dog.name = name;
    }

    public void printName() {
        System.out.println("name = " + name);
    }

}


public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog("rex"); // Creates instance (rex).
        Dog fluffy = new Dog("fluffy"); // Creates instance (fluffy).

        /* Static variables are shared between instances.  Once we change static variable, all instances will see
        * the change that we made.  Both instances share the same variable and the variable changed from rex to fluffy.  */

        rex.printName(); // Prints fluffy.
        fluffy.printName(); // Prints fluffy.
    }

}
