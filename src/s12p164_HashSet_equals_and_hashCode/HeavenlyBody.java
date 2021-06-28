package s12p164_HashSet_equals_and_hashCode;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<HeavenlyBody>();
    }


    public String getName() {
        return name;
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }


    public Set<HeavenlyBody> getSatellites() {
        return satellites;
    }


    public boolean addMoon(HeavenlyBody moon) {
        return satellites.add(moon);
    }

    /* Override the equals() method so duplicated objects won't be added to Set.  */
    @Override
    public boolean equals(Object obj) {
        /* If the two objects are exactly the same, including shared instance, return true.  */
        if(this == obj) {
            return true;
        }
        // System.out.println("obj.getClass() is " + obj.getClass());
        // System.out.println("this.getClass() is " + this.getClass());
        /* If object is null or the object doesn't share the same class, return false.  If I use HeavenlyBody to
        * create all these objects, these objects should share the same class as well.  */
        if ((obj == null) || obj.getClass() != this.getClass()) {
            return false;
        }

        /* Cast object to HeavenlyBody.  */
        String objName = ((HeavenlyBody) obj).getName();

        /* Compare the name value of the two objects, if the name are equal, return true, otherwise return false.
        * Since how Set choose to add items is base on the equals() method, this means the new object with the same
        * name as the old object will not be added.  */
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        // System.out.println("hashCode() called.  ");
        /* 57 is random chosen number.  I try to get the the hashcode of the current object's name variable.  */
        return this.name.hashCode() + 57;
    }
}