package s6p86b_Static_VS_Instance_Methods_b;

class Dog {

    public void bark() {
        System.out.println("woof");
    }

}


public class Main {

    public static void main(String[] args) {
        Dog rex = new Dog(); // Creates instance.
        rex.bark(); // Use object to call instance method.
    }

}
