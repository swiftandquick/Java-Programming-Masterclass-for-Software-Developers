package s7p96_Polymorphism_Challenge_Exercise_Try;

public class Tesla extends Car {

    public Tesla(int cylinders) {
        super("Tesla", cylinders);
    }

    @Override
    public void move() {
        System.out.println("Broom broom broom...  ");
    }

}
