package s12p166_Potential_Issue_with_equals_and_Sub_Classing;

public class Dog {

    private final String name;


    public Dog(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        /* I can only get here if obj doesn't have the same instance.  */
        return false;
    }
}
