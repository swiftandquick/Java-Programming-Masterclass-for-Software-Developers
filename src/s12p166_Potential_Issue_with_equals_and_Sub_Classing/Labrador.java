package s12p166_Potential_Issue_with_equals_and_Sub_Classing;

public class Labrador extends Dog {

    public Labrador(String name) {
        super(name);
    }

    /* If I comment out the method below, second statement will return false, since equals() doesn't exist in
    * Labrador class, Labrador object rover invokes equals() method in Dog class, and find out that both rover
    * and rover2 share the same instance (Dog), thus, return true.  */
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        /* To solve the potential issue with equals() and subclass, also override the equals() method in subclass.
        * In subclass, check if both objects are in the instance of the subclass.  */
        if(obj instanceof Labrador) {
            String objName = ((Labrador) obj).getName();
            return this.getName().equals(objName);
        }
        /* I can only get here if obj doesn't have the same instance.  */
        return false;
    }

}
