package s7p96_Polymorphism_Challenge_Exercise_Try;

public class Mercedes extends Car {

    public Mercedes(int cylinders) {
        super("Mercedes", cylinders);
    }

    @Override
    public void move() {
        System.out.println("Whee whee whee...  ");
    }

}