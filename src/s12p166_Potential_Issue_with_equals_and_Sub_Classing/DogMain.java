package s12p166_Potential_Issue_with_equals_and_Sub_Classing;

public class DogMain {

    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        /* Call equals() in Dog class.  Labrador is an instance of Dog, so first statement returns true.  */
        System.out.println(rover2.equals(rover));

        /* Call equals in Labrador class.  Dog is not an instance of Labrador, the second statement returns false.  */
        System.out.println(rover.equals(rover2));
    }

}
