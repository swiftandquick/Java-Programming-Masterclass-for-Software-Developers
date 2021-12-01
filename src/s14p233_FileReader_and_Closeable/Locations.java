package s14p233_FileReader_and_Closeable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    /* locations is a HashMap that has key of Integer and value of Location.  */
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();


    static {
        Scanner scanner = null;
        try {
            // Use FileReader to read the locations.txt file, which is inside the src folder’s
            // s14p233_FileReader_and_Closeable package.
            scanner = new Scanner(new FileReader("src/s14p233_FileReader_and_Closeable/locations.txt"));
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
        /* finally block, executes whether an exception is caught or not.  */
        finally {
            if(scanner != null) {
                scanner.close();
            }
        }

        // BufferedReader:  Readers text from the input stream and buffers the characters into a character array.
        // FileReader is an input stream for the BufferedReader to use. Read the exits from directions.txt from
        // src folder's s14p233_FileReader_and_Closeable package.
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("src/s14p233_FileReader_and_Closeable/" +
                    "directions.txt")));
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
        finally {
            if(scanner != null) {
                scanner.close();
            }
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
