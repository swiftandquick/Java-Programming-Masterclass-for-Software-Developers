package s6ce32_Point_b;

public class Point {

    private int x;
    private int y;


    public Point() {
    }


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }


    public void setY(int y) {
        this.y = y;
    }


    public double distance() {
        return Math.sqrt(x * x + y * y);
    }


    /* Method overloading.  Distance formula:  sqrt((x2 - x1)^2 + (y2 - y1)^2).  */
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }


    public double distance(Point point) {
        return Math.sqrt(Math.pow((this.x - point.x), 2) + Math.pow((this.y - point.y), 2));
    }

}
