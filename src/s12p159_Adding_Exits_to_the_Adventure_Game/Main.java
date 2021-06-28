package s12p159_Adding_Exits_to_the_Adventure_Game;

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

        locations.get(1).addExit("W", 2); // From 1, go west to 2.
        locations.get(1).addExit("E", 2); // From 1, go east to 3.
        locations.get(1).addExit("S", 2); // From 1, go south to 4.
        locations.get(1).addExit("N", 2); // From 1, go north to 5.
        // locations.get(1).addExit("Q", 0); // Q is keyword for quit.

        locations.get(2).addExit("N", 5); // From 2, go north to 5.
        // locations.get(2).addExit("Q", 0); // Quit.

        locations.get(3).addExit("W", 1); // From 3, go west to 1.
        // locations.get(3).addExit("Q", 0); // Quit.

        locations.get(4).addExit("N", 1); // From 4, go north to 1.
        locations.get(4).addExit("W", 2); // From 4, go west to 2.
        // locations.get(4).addExit("Q", 0); // Quit.

        locations.get(5).addExit("S", 1); // From 5, go south to 1.
        locations.get(5).addExit("W", 2); // From 5, go west to 2.
        // locations.get(5).addExit("Q", 0); // Quit.

        /* Game starts in location 1.  */
        int loc = 1;
        while (true) {
            /* Retrieve the description with locationID.  */
            System.out.println(locations.get(loc).getDescription());
            /* Exit out of loop if scanner input is 0.  */
            if (loc == 0) {
                break;
            }

            /* Retrieve the exits for the specified location (0 to 5).  */
            Map<String, Integer> exits = locations.get(loc).getExits();

            /* Print out the available exits for the specified location.  */
            System.out.print("Available exits are ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            /* Input the direction , possible directions are N, E, S, W, or type in Q to quit.  */
            String direction = scanner.nextLine().toUpperCase();

            /* If exist contains the key, set the current location equal to the value of the returned value.  For
            * example, I am currently in location 5, and the direction is "S", exits.get("S") will return 1,
            * that means the new location is 1.  */
            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else {
                System.out.println("You cannot go in that direction.  ");
            }

        }
    }

}
