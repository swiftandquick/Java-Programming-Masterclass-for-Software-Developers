package s14p242_Create_Random_Access_File;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

// Serializable:  A marker interface that has no methods and fields.
public class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    /* I need to have serialVersionUID or compiling main method in Main class will result NullPointerException.  */
    private long serialVersionUID = 1L;

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
