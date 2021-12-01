package s14p238_Byte_Streams;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    /* Constructor.  */
    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if(exits != null) {
            this.exits = new LinkedHashMap<String, Integer>(exits);
        }
        else {
            this.exits = new LinkedHashMap<String, Integer>();
        }
        /* All locations have exit 0.  */
        this.exits.put("Q", 0);
    }


    /*
    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
     */


    public int getLocationID() {
        return locationID;
    }


    public String getDescription() {
        return description;
    }


    public Map<String, Integer> getExits() {
        return new LinkedHashMap<String, Integer>(exits);
    }


    /* Add direction and location to the exits Map.  */
    protected void addExit(String direction, int location) {
        exits.put(direction, location);
    }

}
