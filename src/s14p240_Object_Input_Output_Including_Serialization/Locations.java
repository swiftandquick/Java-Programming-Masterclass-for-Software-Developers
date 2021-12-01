package s14p240_Object_Input_Output_Including_Serialization;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    /* locations is a LinkedHashMap that has key of Integer and value of Location.  */
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();


    /* Create another main method.  This main method throws IOException.  */
    public static void main(String[] args) throws IOException {
        // ObjectOutputStream:  Writes primitive data types and graphs of Java objects to an OutputStream.
        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream
                ("src/s14p240_Object_Input_Output_Including_Serialization/locations.dat")))) {
            for(Location location : locations.values()) {
                // Write the object into the locations.dat file.
                locFile.writeObject(location);
            }
        }
    }


    // 1.  The first four bytes will contain the number of locations (bytes 0-3).
    // 2.  The next four bytes will contain the start offset of the locations section (bytes 4-7).
    // 3.  The next section of the file will contain the index.  The index is 1692 bytes long (bytes 8-1699).
    // 4.  The final section will contain the location records (data).  (stat at byte 1700).

    static {
        // ObjectInputStream:  Deserializes primitive data and objects previously written using an ObjectOutputStream.
        try (ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream
                    ("src/s14p240_Object_Input_Output_Including_Serialization/locations.dat")))) {
            boolean eof = false;
            // While loop iterates until there is an EOFException.
            while(!eof) {
                try {
                    Location location = (Location) locFile.readObject(); // Reads the next object.
                    System.out.println("Read location " + location.getLocationID() + ":  " + location.getDescription());
                    System.out.println("Found " + location.getExits().size() + " exits.  ");
                    locations.put(location.getLocationID(), location);
                }
                catch(EOFException e) {
                    eof = true;
                }
            }
        }
        // Thrown when the Serialization runtime detects one of the following problems with a Class.
        // The serial version of the class does not match that of the class descriptor read from the stream.
        // The class contains unknown data types.  The class does not have an accessible no-arg constructor.
        catch(InvalidClassException e) {
            System.out.println("InvalidClassException " + e.getMessage());
        }
        catch(IOException e) {
            System.out.println("IOException " + e.getMessage());
        }
        // ClassNotFoundException:  Thrown when an application tries to load in a class through its String name using:
        // the forName method in class Class, the findSystemClass method in class ClassLoader, or the loadClass method
        // in class ClassLoader.
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFounException " + e.getMessage());
        }
        /*
        // Use FileReader to read the locations_big.txt file, which is inside the src folder’s
        // s14p240_Object_Input_Output_Including_Serialization package.
        try(Scanner scanner = new Scanner(new FileReader("src/" +
                "s14p240_Object_Input_Output_Including_Serialization/locations_big.txt"));) {
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
        // src folder's s14p240_Object_Input_Output_Including_Serialization package.
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src" +
                "/s14p240_Object_Input_Output_Including_Serialization/directions_big.txt")))){
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
         */
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
