package s6p84_this_VS_super_b;


class SuperClass { // Parent class aka super class.

    public void printMethod() {
        System.out.println("Printed in Superclass.  ");
    }

}


class SubClass extends SuperClass { // subclass aka child class

    // Overrides method from parent.
    @Override
    public void printMethod() {
        super.printMethod(); // Calls printMethod() in SuperClass (parent)
        System.out.println("Printed in Subclass.  ");
    }

}


public class MainClass {

    public static void main(String[] args) {
        SubClass s = new SubClass();
        /* Call printMethod() of Subclass.  */
        s.printMethod();
    }

}
