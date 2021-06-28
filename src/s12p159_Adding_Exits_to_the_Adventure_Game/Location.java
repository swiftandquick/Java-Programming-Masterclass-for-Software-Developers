package s12p159_Adding_Exits_to_the_Adventure_Game;

import java.util.HashMap;
import java.util.Map;

public class Location {

    /* I programmed this class defensively with final variables.  Anything that doesn't need to be exposed to the
    * outside isn't exposed.  Value can't be changed once constructor is called.  */
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;


    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        exits = new HashMap<String, Integer>();
        /* Type in "Q" or "q" to quit, because every locations HashMap has a key-value pair that is "Q", 0 as the
        constructor is created.  Since the key "Q" has the value of 0, 0 means exit the game, that means I can
        quit the game at any location.  */
        exits.put("Q", 0);
    }


    public int getLocationID() {
        return locationID;
    }


    public String getDescription() {
        return description;
    }


    /* Instead of returning the exits Map, I create a new HashMap and pass exits in the HashMap's constructor.
    * The new HashMap object has all the makings of the the exits map.  It's useful to do that because nothing
    * outside of that class can change exits, so the getter returns a copy of exits.  So, if the calling program
    * wants to add or remove mappings from it and the exits mapping field won't be affected.  */
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }


    /* Add an entry to the exits HashMap.  */
    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

}
