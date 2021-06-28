package s6p77_Classes;

public class Main {

    public static void main(String[] args) {
        /* Create an object "porsche" using "Car" class as blueprint.  Initialize porsche with new keyword.  */
        Car porsche = new Car();
        Car holden = new Car();

        /* Model is not set yet, so getter retrieves "null".  */
        System.out.println("Model is " + porsche.getModel());

        /* It will return Unknown.  */
        porsche.setModel("911");
        System.out.println("Model is " + porsche.getModel());

        /* Call the setter to set model.  */
        porsche.setModel("Carrera");

        /* Call the getter to retrieve model.  */
        System.out.println("Model is " + porsche.getModel());

    }

}
