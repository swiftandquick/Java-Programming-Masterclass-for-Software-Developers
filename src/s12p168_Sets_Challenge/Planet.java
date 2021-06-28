package s12p168_Sets_Challenge;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        /* Body type is PLANET for all planet objects.  */
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    /* For PLANET, only add satellite if the BodyType of Satellite is MOON.  */
    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyTypes.MOON) {
            /* Call the super method to add satellite.  */
            return super.addSatellite(moon);
        }
        else {
            return false;
        }
    }

}
