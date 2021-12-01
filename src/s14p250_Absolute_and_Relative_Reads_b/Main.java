package s14p250_Absolute_and_Relative_Reads_b;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("src/s14p250_Absolute_and_Relative_Reads_b/data.dat");
            FileChannel binChannel = binFile.getChannel()) {

            // Create a ByteBuffer, allocate 100 bytes.
            ByteBuffer buffer = ByteBuffer.allocate(100);

            /*
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            // Chaining put methods, put multiple String and int into buffer.
            buffer.put(outputBytes).putInt(245).putInt(-98765).put(outputBytes2).putInt(1000);
            buffer.flip();
             */

            // Encode a String into a sequence of array and store the bytes in a byte array.
            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);
            long int1Pos = outputBytes.length;
            // int1Pos is 12, which is the size of outputBytes.
            // System.out.println(int1Pos);
            buffer.putInt(245);
            // int2Pos is 12 (int1Pos) + 4 (Integer.BYTES) = 16.
            long int2Pos = int1Pos + Integer.BYTES;
            // System.out.println(int2Pos);
            buffer.putInt(-98765);
            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);
            // int3Pos is 16 (int2Pos) + 4 (Integer.BYTES) + 16 (size of outputBytes2) = 36.
            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            // System.out.println(int3Pos);
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);

            // Create a RandomAccessFile for read and write synchronously.
            RandomAccessFile ra = new RandomAccessFile("src/s14p250_Absolute_and_Relative_Reads_b/data.dat",
                    "rwd");
            FileChannel channel = ra.getChannel();

            // Use channel to read a sequence of 100 bytes.
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);

            readBuffer.flip();

            // outputBytes.length is 12, so new byte array inputString also has the length of 12.
            byte[] inputString = new byte[outputBytes.length];
            // Relative bulk get method.  Get the first 12 bytes from data.dat.
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            // Get the next int from data.dat.
            System.out.println("int1 = " + readBuffer.getInt());
            // Get the second int from data.dat.
            System.out.println("int2 = " + readBuffer.getInt());
            // Get the second String from data.dat.
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            // Get the third int from data.dat.
            System.out.println("int3 = " + readBuffer.getInt());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
