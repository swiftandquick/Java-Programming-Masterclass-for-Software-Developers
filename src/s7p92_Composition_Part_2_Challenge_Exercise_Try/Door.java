package s7p92_Composition_Part_2_Challenge_Exercise_Try;

public class Door {

    private double length;
    private double height;
    private String material;


    public Door(double length, double height, String material) {
        this.length = length;
        this.height = height;
        this.material = material;
    }


    public void open() {
        System.out.println("Open the " + material + " door.  ");
    }

}
