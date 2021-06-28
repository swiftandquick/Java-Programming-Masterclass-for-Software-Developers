package s11p151_The_Final_Statement;

public class SomeClass {

    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;


    /* Once constructor is called, instanceNumber's value is assigned as equal to classCounter.  Same with name.
    * classCounter is a static variable, it increment by 1 every time the constructor is called.  */
    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }


    public int getInstanceNumber() {
        return instanceNumber;
    }

}
