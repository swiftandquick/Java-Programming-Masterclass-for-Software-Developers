package s12p162_Immutable_Class_Challenge;

import java.util.HashMap;
import java.util.Map;

public final class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;


    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        /* If exits is not null, set exits equal to exits from parameter, otherwise declare a new HashMap.  */
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        }
        else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }


    public int getLocationID() {
        return locationID;
    }


    public String getDescription() {
        return description;
    }


    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }

    /* Since I use constructor to set up exits, I no longer need the addExit method.  */
    /*
    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }
     */
}