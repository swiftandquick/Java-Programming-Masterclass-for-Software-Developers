package s14p242_Create_Random_Access_File;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {

    /* locations is a LinkedHashMap that has key of Integer and value of Location.  */
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();
    /* This Map contains each location ID and its index record.  */
    private static Map<Integer, IndexRecord> index = new LinkedHashMap<Integer, IndexRecord>();
    private static RandomAccessFile ra;


    /* Create another main method.  This main method throws IOException.  */
    public static void main(String[] args) throws IOException {
        // RandomAccessFile:  Read and write to  random access file.  A random access file behaves like a large array
        // of bytes.
        // rwd:  Read and write mode - synchronously. All updates to file content is written to the disk synchronously.
        try (RandomAccessFile rao = new RandomAccessFile("src/s14p242_Create_Random_Access_File/locations_rand.dat",
                "rwd")) {
            // 1.  The first four bytes will contain the number of locations (bytes 0-3).
            rao.writeInt(locations.size());
            // 2.  The next four bytes will contain the start offset of the locations section (bytes 4-7).
            int indexSize = locations.size() *  3 * Integer.BYTES;
            // getFilePointer:  Returns the offset from the beginning of the file, in bytes, at which the next read or
            // write occurs.
            int locationStart = (int) (indexSize + rao.getFilePointer() + Integer.BYTES);
            rao.writeInt(locationStart);
            // 3.  The next section of the file will contain the index.  The index is 1692 bytes long (bytes 8-1699).
            long indexStart = rao.getFilePointer();
            int startPointer = locationStart;
            // seek:  Sets the file-pointer offset, measured from the beginning of this file, at which the next read
            // or write occurs.  startPointer is an int variable, it represents the position.
            rao.seek(startPointer);
            for(Location location : locations.values()) {
                rao.writeInt(location.getLocationID()); // Write the locationID.
                rao.writeUTF(location.getDescription()); // Write the description.
                StringBuilder builder = new StringBuilder();
                // Write the exits that are not "Q".
                for(String direction : location.getExits().keySet()) {
                    if(!direction.equalsIgnoreCase("Q")) {
                        builder.append(direction);
                        builder.append(",");
                        builder.append(location.getExits().get(direction));
                        builder.append(",");
                    }
                }
                rao.writeUTF(builder.toString());
                // startByte is the startPointer, length is current pointer subtract by startPointer.
                IndexRecord record = new IndexRecord(startPointer, (int) (rao.getFilePointer() - startPointer));
                // Put both locationID and record into the index Map.
                index.put(location.getLocationID(), record);
                // Set startPointer to current pointer before for loop iterates again.
                startPointer = (int) rao.getFilePointer();
            }
            // 4.  The final section will contain the location records (data).  (stat at byte 1700).
            rao.seek(indexStart);
            for(Integer locationID : index.keySet()) {
                rao.writeInt(locationID);
                // Gets the startByte length from IndexRecord, and writes them in locations_rand.dat.
                rao.writeInt(index.get(locationID).getStartByte());
                rao.writeInt(index.get(locationID).getLength());
            }
        }
    }


    // 1.  The first four bytes will contain the number of locations (bytes 0-3).
    // 2.  The next four bytes will contain the start offset of the locations section (bytes 4-7).
    // 3.  The next section of the file will contain the index.  The index is 1692 bytes long (bytes 8-1699).
    // 4.  The final section will contain the location records (data).  (stat at byte 1700).  

    static {
        try {
            ra = new RandomAccessFile("src/s14p242_Create_Random_Access_File/locations_rand.dat", "rwd");
            // 1.  The first four bytes will contain the number of locations (bytes 0-3).
            int numLocations = ra.readInt();
            // 2.  The next four bytes will contain the start offset of the locations section (bytes 4-7).
            long locationStartPoint = ra.readInt();
            while (ra.getFilePointer() < locationStartPoint) {
                int locationId = ra.readInt();
                int locationStart = ra.readInt();
                int locationLength = ra.readInt();
                IndexRecord record = new IndexRecord(locationStart, locationLength);
                index.put(locationId, record);
            }
        }
        catch(IOException e) {
            System.out.println("IOException in static initializer:  " + e.getMessage());
        }

        /*
        // Use FileReader to read the locations_big.txt file, which is inside the src folder’s
        // s14p242_Create_Random_Access_File package.
        try(Scanner scanner = new Scanner(new FileReader("src/" +
                "s14p242_Create_Random_Access_File/locations_big.txt"));) {
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
        // src folder's s14p242_Create_Random_Access_File package.
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("src" +
                "/s14p242_Create_Random_Access_File/directions_big.txt")))){
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


    /* Returns Location.  */
    public Location getLocation(int locationId) throws IOException {
        IndexRecord record = index.get(locationId);
        ra.seek(record.getStartByte());
        int id = ra.readInt();
        String description = ra.readUTF();
        String exits = ra.readUTF();
        String[] exitPart = new String(exits).split(",");
        // Set exits to null initially.
        Location location = new Location(locationId, description, null);
        // Add exits to exits Map.
        if(locationId != 0) {
            for(int i = 0; i < exitPart.length; i++) {
                System.out.println("exitPart = " + exitPart[i]);
                System.out.println("exitPart[+1] = " + exitPart[i + 1]);
                String direction = exitPart[i];
                int destination = Integer.parseInt(exitPart[++i]);
                location.addExit(direction, destination);
            }
        }

        return location;
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


    /* Close the RandomAccessFile ra.  */
    public void close() throws IOException {
        ra.close();
    }

}
