package s7p92_Composition_Part_2_Challenge_Exercise_Try;

public class Light {

    private int lumen;
    private String lightColor;


    public Light(int lumen, String lightColor) {
        this.lumen = lumen;
        this.lightColor = lightColor;
    }


    public void turnOn() {
        System.out.println("Turn on the " + lumen + " lumens " + lightColor + " light.  ");
    }

}
