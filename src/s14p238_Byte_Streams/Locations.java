package s14p238_Byte_Streams;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    /* locations is a LinkedHashMap that has key of Integer and value of Location.  */
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();


    /* Create another main method.  This main method throws IOException.  */
    public static void main(String[] args) throws IOException {
        // DataOutputStream:  Write primitive Java data types to an output stream in a portable way.
        try (DataOutputStream locFile = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/"
                + "s14p238_Byte_Streams/locations.dat")))){
            // Values of locations is Location.
            for(Location location : locations.values()) {
                locFile.writeInt(location.getLocationID()); // Write an int (locationID).
                locFile.writeUTF(location.getDescription()); // Write a String (description).
                System.out.println("Writing location - " + location.getLocationID() + ":  " + location.getDescription());
                // Subtract 1 because quit isn't an exit.
                System.out.println("Writing " + (location.getExits().size() - 1) + " exits.  ");
                for(String direction : location.getExits().keySet()) {
                    // Write down the non-quit directions.
                    if(!direction.equalsIgnoreCase("Q")) {
                        System.out.println("\t\t" + direction + "," + location.getExits().get(direction));
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }


    static {
        /*
        // DataInputStream:  Let an application read primitive Java data types from an underlying input stream.
        try (DataInputStream locFile = new DataInputStream(new BufferedInputStream(new FileInputStream
                    ("src/s14p238_Byte_Streams/locations.dat")))) {
            boolean eof = false;
            // While loop iterates until there is an EOFException.
            while(!eof) {
                try {
                    Map<String, Integer> exits = new LinkedHashMap<String, Integer>();
                    int locID = locFile.readInt(); // Reads the next int.
                    String description = locFile.readUTF(); // Read the next String.
                    int numExits = locFile.readInt(); // Reads next int.
                    System.out.println("Read location " + locID + ":  " + description);
                    System.out.println("Found " + numExits + " exits.  ");
                    // For each numExits.
                    for (int i = 0; i < numExits; i++) {
                        String direction = locFile.readUTF(); // Get next String as direction.
                        int destination = locFile.readInt(); // Get next int as destination.
                        exits.put(direction, destination); // Put each exit into the Map exits.
                        System.out.println("\t\t" + direction + "," + destination);
                    }
                    // Add each locID and each Location into the locations Map.
                    locations.put(locID, new Location(locID, description, exits));
                }
                // EOFException:  Signals that an end of file or end of stream has been reached unexpectedly during input.
                catch(EOFException e) {
                    eof = true;
                }
            }
        }
        catch(IOException e) {
            System.out.println("I/O Exceptions.  ");
        }
         */

        // Use FileReader to read the locations_big.txt file, which is inside the src folder’s
        // s14p235_Load_Big_Location_and_Exits_Files package.
        try(Scanner scanner = new Scanner(new FileReader("src/s14p238_Byte_Streams" +
                "/locations_big.txt"));) {
            // useDelimiter():  Use to set delimiting pattern of the Scanner which is in using.  In this case, scanner
            // separate our information by comma.
            scanner.useDelimiter(",");
            // Check each line of the file.
            while(scanner.hasNextLine()) {
                // Set loc (location) equals next int that is read, for example 0.
                int loc = scanner.nextInt();
                // Skips the delimiter, delimiter is set to comma in this case.
                scanner.skip(scanner.delimiter());
                // Set description to rest of the line.
                String description = scanner.nextLine();
                System.out.println("Imported loc - " + loc + ":  " + description);
                Map<String, Integer> tempExit = new HashMap<String, Integer>();
                // Put the location in the locations HashMap.
                locations.put(loc, new Location(loc, description, tempExit));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // BufferedReader:  Readers text from the input stream and buffers the characters into a character array.
        // FileReader is an input stream for the BufferedReader to use.  Read the exits from directions_big.txt from
        // src folder's ss14p235_Load_Big_Location_and_Exits_Files package.
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src" +
                "/s14p238_Byte_Streams/directions_big.txt")))){
            // Separate data by comma.
            scanner.useDelimiter(",");
            // Check each line of the file, each line has the format of "0,Q,0".
            while(scanner.hasNextLine()) {
                // Split the String and store each element of the data String into loc, direction, and destination.
                String input = scanner.nextLine();
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + ":  " + direction + ":  " + destination);
                // Add exits to the location.
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int size() {
        return locations.size();
    }


    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }


    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }


    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }


    @Override
    public Location get(Object key) {
        return locations.get(key);
    }


    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }


    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }


    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
    }


    @Override
    public void clear() {
        locations.clear();
    }


    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }


    @Override
    public Collection<Location> values() {
        return locations.values();
    }


    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }

}
