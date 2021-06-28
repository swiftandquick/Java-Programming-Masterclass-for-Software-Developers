package s12p158_Map_Continued_and_Adventure_Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /* Create Map object locations, with key as Integer type and value as Location type.  */
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java.  "));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building.  "));
        locations.put(2, new Location(2, "You are at the top of a hill.  "));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring.  "));
        locations.put(4, new Location(4, "You are in a valley beside a stream.  "));
        locations.put(5, new Location(5, "You are in the forest.  "));

        int loc = 1;
        while (true) {
            /* Retrieve the description with locationID.  */
            System.out.println(locations.get(loc).getDescription());
            /* Exit out of loop if scanner input is 0.  */
            if (loc == 0) {
                break;
            }
            /* I get to choose what locationID I should put in next, if I put in 0 to 5, I will receive description.  */
            loc = scanner.nextInt();
            /* There will be in error if input is outside of the range of 0 to 5.  */
            if(!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction.  ");
            }
        }
    }

}
