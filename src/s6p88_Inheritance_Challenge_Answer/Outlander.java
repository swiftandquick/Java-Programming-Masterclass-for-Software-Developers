package s6p88_Inheritance_Challenge_Answer;

public class Outlander extends Car {

    private int roadServiceMonths;


    public Outlander(int roadServiceMonths) {
        super("Outlander", "4WD", 5, 5, 6, false);
        this.roadServiceMonths = roadServiceMonths;
    }


    public void accelerate(int rate) {
        /* Change the velocity based on rate input.  Get the current velocity by calling the getter getCurrentVelocity().  */
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0) {
            /* Call the stop() method if newVelocity is 0.  */
            stop();
            /* Call the changeGear method and change gear to 1.  */
            changeGear(1);
        }
        /* Change gear based on velocity.  */
        else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        }
        else if (newVelocity > 10 && newVelocity <= 20) {
            changeGear(2);
        }
        else if (newVelocity > 20 && newVelocity <= 30) {
            changeGear(3);
        }
        else {
            changeGear(4);
        }

        /* Call getCurrentDirection() to get currentDirection, change velocity but keep the direction.  */
        if (newVelocity > 0) {
            /* Call the changeVelocity() method, parameters are newVelocity and getCurrentDirection().  */
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }

}
