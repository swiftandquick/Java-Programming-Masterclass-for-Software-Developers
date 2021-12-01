package s14p245_Java_NIO;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class Locations implements Map<Integer, Location> {

    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();


    public static void main(String[] args) throws IOException {

        Path locPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/locations.dat");

        try (ObjectOutputStream locFile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream
                (locPath)))) {
            for(Location location : locations.values()) {
                locFile.writeObject(location);
            }
        }

        /*
        // getPath():  Returns the path of the given file object, in this case, it's locations_big.txt.
        Path locPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/locations_big.txt");
        // Get the path of directions_big.txt.
        Path dirPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/directions_big.txt");
        // newBufferWriter:  Opens or creates a file for writing.
        try(BufferedWriter locFile = Files.newBufferedWriter(locPath);
            BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
            for(Location location : locations.values()) {
                // Write down locationID and description.
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                // Write down locationID, direction, and exits.
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        dirFile.write(location.getLocationID() + "," + direction + "," +
                                location.getExits().get(direction) + "\n");
                    }
                }
            }
        }
        catch(IOException e) {
            System.out.println("IOException:  " + e.getMessage());
        }
         */
    }


    static {

        Path locPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/locations.dat");
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while(!eof) {
                try {
                   Location location = (Location) locFile.readObject();
                   locations.put(location.getLocationID(), location);
                }
                catch(EOFException e) {
                    eof = true;
                }
            }
        }
        catch(InvalidClassException e) {
            System.out.println("InvalidClassException:  " + e.getMessage());
        }
        catch(IOException e) {
            System.out.println("IOException:  " + e.getMessage());
        }
        catch(ClassNotFoundException e) {
            System.out.println("ClassNotFoundException:  " + e.getMessage());
        }

        /*
        Path locPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/locations_big.txt");
        Path dirPath = FileSystems.getDefault().getPath("src/s14p245_Java_NIO/directions_big.txt");

        // newBufferedReader:  Opens a file for reading.
        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()) {
                int loc = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description = scanner.nextLine();
                System.out.println("Imported loc - " + loc + ":  " + description);
                locations.put(loc, new Location(loc, description, null));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
            String input;

            while ((input = dirFile.readLine()) != null) {
                String[] data = input.split(",");
                int loc = Integer.parseInt(data[0]);
                String direction = data[1];
                int destination = Integer.parseInt(data[2]);
                System.out.println(loc + " - " + direction + ":  " + destination);
                Location location = locations.get(loc);
                location.addExit(direction, destination);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
         */

        /*
        // Use FileReader to read the locations_big.txt file, which is inside the src folder’s
        // s14p240_Object_Input_Output_Including_Serialization package.
        try(Scanner scanner = new Scanner(new FileReader("src/" +
                "s14p245_Java_NIO/locations_big.txt"));) {
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
                "/s14p245_Java_NIO/directions_big.txt")))){
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
