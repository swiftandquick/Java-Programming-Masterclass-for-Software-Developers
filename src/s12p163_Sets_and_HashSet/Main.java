package s12p163_Sets_and_HashSet;

import java.util.*;

public class Main {

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<String, HeavenlyBody>();
    private static Set<HeavenlyBody> planets = new HashSet<HeavenlyBody>();


    public static void main(String[] args) {
        /* temp represents a planet.  Reset the temp variable every time, but not before add temp to planets Set and
        solarSystem Map first.  */
        HeavenlyBody temp = new HeavenlyBody("Mercury", 88);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Venus", 225);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Earth", 365);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        /* tempMoon represents a moon.  Reset the tempMoon variable every time, but not before add tempMoon to
        solarSystems and add tempMoon to temp's (currently "Earth") satellites Set first.  */
        HeavenlyBody tempMoon = new HeavenlyBody("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is Earth.

        temp = new HeavenlyBody("Mars", 687);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars.

        tempMoon = new HeavenlyBody("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Mars.

        temp = new HeavenlyBody("Jupiter", 4332);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        tempMoon = new HeavenlyBody("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter.

        tempMoon = new HeavenlyBody("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter.

        tempMoon = new HeavenlyBody("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter.

        tempMoon = new HeavenlyBody("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        temp.addMoon(tempMoon); // temp is still Jupiter.

        temp = new HeavenlyBody("Saturn", 10759);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Uranus", 30660);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Neptune", 165);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        temp = new HeavenlyBody("Pluto", 248);
        solarSystem.put(temp.getName(), temp);
        planets.add(temp);

        System.out.println("Planets");
        /* Print out the name variable of objects stored inside the planets Set.  The order is printed randomly
        * because a Set is unsorted and unordered.  */
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getName());
        }

        /* Gets the HeavenlyBody object with the key of "Jupiter", which returns the HeavenlyBody object with the
        * name (instance variable) value being "Jupiter".  */
        HeavenlyBody body = solarSystem.get("Jupiter");
        System.out.println("Moons of " + body.getName());
        /* Print out the satellites of Jupiter.  */
        for(HeavenlyBody jupiterMoon : body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getName());
        }

        /* Print the moons of Mars.  */
        body = solarSystem.get("Mars");
        System.out.println("Moons of " + body.getName());
        for(HeavenlyBody marsMoon : body.getSatellites()) {
            System.out.println("\t" + marsMoon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<HeavenlyBody>();
        for(HeavenlyBody planet : planets) {
            /* addAdd() method can add an existing Set into another Set.  planet.getSatellite() returns a Set of
            * HeavenlyBody objects (representing moons of each planet), which I can then add to a bigger Set:  moons.  */
            moons.addAll(planet.getSatellites());
        }

        System.out.println("Moons");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }
    }

}
