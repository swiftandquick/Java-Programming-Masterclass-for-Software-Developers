package s6p84_this_VS_super_d;

class Shape {

    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

}


class Rectangle extends Shape {

    private int width;
    private int height;

    // 1st constructor
    public Rectangle(int x, int y) {
        this(x, y, 0, 0); // Calls 2nd constructor.
    }

    // 2nd constructor
    public Rectangle(int x, int y, int width, int height) {
        /* Parent constructor (Shape) will initialize x, y variables while the 2nd Rectangle constructor will initialize
        * the width and height variables.  */
        super(x, y); // Calls constructor from parent (Shape)
        this.width = width;
        this.height = height;
    }

}