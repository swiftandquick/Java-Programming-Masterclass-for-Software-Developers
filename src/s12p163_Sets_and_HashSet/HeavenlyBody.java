package s12p163_Sets_and_HashSet;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    /* The variable satellites represent the satellites of a heavenly body, which refer to other heavenly bodies.  */
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

}