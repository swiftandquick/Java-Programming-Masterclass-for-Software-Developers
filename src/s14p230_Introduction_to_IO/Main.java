package s14p230_Introduction_to_IO;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Locations locations = new Locations();


    public static void main(String[] args) {
        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.

        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDescription());

            /* 0 is quit.  Break out of while loop.  */
            if(loc == 0) {
                break;
            }

            /* get(loc) gets the Location (value) of the locations Map, then invoke getExits() from Location class
            * to get the HashMap, which contains of String (key, represents direction) and Integer (value, represents
            * location ID).  */
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            /* Print out the exits (String type key).  */
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            /* If input String length is greater than 1, check if the String contains the word.  Use get() method to
            * get the value of based on key, and save it into the direction variable.  */
            String direction = scanner.nextLine().toUpperCase();
            if(direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            /* If loc contains key, then set loc equals to value of key (direction).  */
            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            /* Otherwise, loc value remains the same and display a message telling me that I can't go to that direction.  */
            else {
                System.out.println("You cannot go in that direction");
            }
        }

    }

}
