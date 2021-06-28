package s6p84_this_VS_super_c;

// Constructor chaining example.
public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;


    // 1st constructor
    public Rectangle() {
        this(0, 0); // Calls 2nd constructor.
    }


    // 2nd constructor
    public Rectangle(int width, int height) {
        this(0, 0, width, height); // Calls 3rd constructor.
    }


    /* No matter what constructor we call, the variables will always be initialized in 3rd constructor.  */
    // 3rd constructor
    public Rectangle(int x, int y, int width, int height) {
        // Initialize variables.
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

}
