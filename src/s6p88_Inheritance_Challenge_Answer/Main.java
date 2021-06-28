package s6p88_Inheritance_Challenge_Answer;

public class Main {

    public static void main(String[] args) {

        Outlander outlander = new Outlander(36);

        /* Call the steer() method in Vehicle class.  */
        outlander.steer(45);

        /* Call accelerateMethod() in Outlander class, parameter is 30.  */
        outlander.accelerate(30);

        /* Call accelerateMethod() again, parameter is 20.  Which means newVelocity is 50.  */
        outlander.accelerate(20);

        outlander.accelerate(-42);

    }

}
