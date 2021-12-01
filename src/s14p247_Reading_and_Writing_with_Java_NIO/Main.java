package s14p247_Reading_and_Writing_with_Java_NIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            /*
            FileInputStream file = new FileInputStream("src/s14p247_Reading_and_Writing_with_Java_NIO/data.txt");
            // FileChannel:  A channel that is connected to a file.
            // file is data.txt, getChannel() to get the FileChannel.  If I create a FileChannel from FileInputStream,
            // the file is only open for reading.
            FileChannel channel = file.getChannel();
             */

            Path dataPath = FileSystems.getDefault().getPath("src/s14p247_Reading_and_Writing_with_Java_NIO/data.txt");

            // Append "\nLine 4" to the file of dataPath (data.txt).  UTF-8 is the character set, set operation to Append.
            Files.write(dataPath, "\nLine 4".getBytes("UTF-8"), StandardOpenOption.APPEND);

            // Read all lines from file of dataPath (data.txt), then store each line as a String object in List.
            List<String> lines = Files.readAllLines(dataPath);
            // Print out each line.
            for(String line : lines) {
                System.out.println(line);
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
