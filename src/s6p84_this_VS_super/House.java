package s6p84_this_VS_super;

public class House {

    private String color;

    public House(String color) {
        // this keyword is required, same parameter name as field.
        this.color = color;
    }


    public String getColor() {
        // this is optional
        return color; // Same as return this.color;
    }


    public void setColor(String color) {
        // this keyword is required, same parameter name as field.
        this.color = color;
    }

}
