package s7p96_Polymorphism_Challenge_Exercise_Try;

public class Toyota extends Car {


    public Toyota(int cylinders) {
        super("Toyota", cylinders);
    }


    @Override
    public void move() {
        System.out.println("Vroom vroom vroom...  ");
    }

}