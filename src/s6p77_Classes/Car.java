package s6p77_Classes;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;


    /* Setter:  Sets the value of an instance variable.
    model in the parameter is an argument.  */
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if (validModel.equals("carrera") || validModel.equals("commodore")) {
            /* this.model refers to the object's instance variable model.
             * Set instance variable model equals to model from parameter.  */
            this.model = model;
        }
        else {
            this.model = "Unknown";
        }
    }


    /* Getter:  Retrieves the value of an instance variable.  */
    public String getModel() {
        return this.model;
    }

}
