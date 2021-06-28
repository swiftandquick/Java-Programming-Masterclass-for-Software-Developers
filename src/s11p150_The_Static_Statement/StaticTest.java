package s11p150_The_Static_Statement;

public class StaticTest {

    /* numInstances is a static variable, means all instances share the same numInstances variable.  */
    private static int numInstances = 0;
    private String name;


    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }


    /* Because getNumInstances() is a static method, I can use the class name to invoke this method rather than
    * the object variable name.  */
    public static int getNumInstances() {
        return numInstances;
    }


    public String getName() {
        return name;
    }

}
