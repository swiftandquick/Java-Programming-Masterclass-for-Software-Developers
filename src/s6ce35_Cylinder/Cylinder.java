package s6ce35_Cylinder;

public class Cylinder extends Circle {

    private double height;


    public Cylinder(double radius, double height) {
        super(radius);
        if (height < 0) {
            this.height = 0;
        }
        else {
            this.height = height;
        }
    }


    public double getHeight() {
        return height;
    }


    public double getVolume() {
        /* Call the getArea() method to get the area.  */
        return getArea() * height;
    }

}
