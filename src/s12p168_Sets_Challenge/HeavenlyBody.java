package s12p168_Sets_Challenge;

import java.security.Key;
import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {

    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;


    /* Create an enum to store constants that represent body types.  */
    public enum BodyTypes {
        STAR, PLANET, DWARF_PLANET, MOON, COMET, ASTEROID
    }


    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        /* Key class contaibns the attribute of name and bodyType.  */
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public Key getKey() {
        return key;
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }


    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }


    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    /* Make a key.  Return the Key object of specified name and BodyTypes.  */
    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }


    @Override
    public final boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        /* Check if the two objects have the same instance.  */
        if(obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            /* Check if the two keys are equal by invoking the equals() method in the Key class.  */
            return this.key.equals(theObject.getKey());
        }
        /* If instance of the two objects are not the same, return false.  */
        else {
            return false;
        }
    }


    /* Call the hashCode() method in the Key class.  */
    @Override
    public final int hashCode() {
        // System.out.println("hashcode called");
        return this.key.hashCode();
    }


    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }


    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            /* Check if name are equal.  */
            if(this.name.equals(key.getName())) {
                /* Check if BodyType are equal.  */
                return this.bodyType == key.getBodyType();
            }
            /* If name is different, return false.  */
            else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 57;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }

}
