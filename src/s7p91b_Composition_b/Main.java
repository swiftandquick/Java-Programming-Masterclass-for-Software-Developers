package s7p91b_Composition_b;

public class Main {

    public static void main(String[] args) {
        /* dimensions is the instance of the Dimensions class, I set the width, height, and depth.  */
        Dimensions dimensions = new Dimensions(20, 20, 5);
        /* Use dimensions as parameter for the constructor.  */
        Case theCase = new Case("220B", "Dell", "240", dimensions);

        /* I created an instance of the Resolution class without using a variable.  The Resolution object is unnamed,
        * but has the width of 2540 and height of 1440.  */
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));

        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        /* Create a PC class by passing three objects as the constructor's parameter.  */
        PC thePC = new PC(theCase, theMonitor, theMotherboard);

        /* drawPixelAt() is a method unique to Monitor class.  Use getMonitor() to return the instance of the Monitor class,
        * then use the returned Monitor object to call the drawPixelAt() method.  */
        thePC.getMonitor().drawPixelAt(1500, 1200, "red");

        /* I can also gain access to methods in Motherboard and Case classes in the same way, using getters.  */
        thePC.getMotherboard().loadProgram("Windows 1.0");
        thePC.getTheCase().pressPowerButton();
    }

}
