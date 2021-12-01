package s14p248_Writing_Binary_Files_with_Java_NIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("src/s14p248_Writing_Binary_Files_with_Java_NIO/" +
                "data.dat");
            FileChannel binChannel = binFile.getChannel()) {

            // Encode a String into a sequence of array and store the bytes in a byte array.
            byte[] outputBytes = "Hello World!".getBytes();
            // Wrap the byte array (outputBytes) into a buffer.
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);

            // Write the bytes in binChnnel.  write() method returns number of bytes written.
            int numBytes = binChannel.write(buffer);
            System.out.println("numBytes written was:  " + numBytes + ".  ");

            // Call the allocate() method, pass the size as number of bytes in an integer.
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            // Writes four bytes containing the given int value.
            intBuffer.putInt(245);
            // Flips this buffer.  The limit is set to the current position and then the position is set to zero.
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was:  " + numBytes + ".  ");

            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was:  " + numBytes + ".  ");

            /*
            // Create a RandomAccessFile that can read and write synchronously.
            RandomAccessFile ra = new RandomAccessFile("src/s14p248_Writing_Binary_Files_with_Java_NIO/data.dat",
                    "rwd");
            // Set byte array equals to the length of outputBytes.  outputBytes is the size of the String.
            byte[] b = new byte[outputBytes.length];

            // ra is RandomAccessFile, b is byte array.  Reads up to b.length bytes.
            ra.read(b);

            // Print out the byte array b in String format.
            System.out.println(new String(b));

            // Reads and prints ouf the next 2 integers.
            long int1 = ra.readInt();
            long int2 = ra.readInt();
            System.out.println(int1);
            System.out.println(int2);
             */

            // Create a RandomAccessFile that can read and write synchronously.
            RandomAccessFile ra = new RandomAccessFile("src/s14p248_Writing_Binary_Files_with_Java_NIO/data.dat",
                    "rwd");
            FileChannel channel = ra.getChannel();

            // Change the byte value of first index and second index of outputBytes.
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            // Calling flip() is able to read the byte array back in, which gets "Hello World!" printed again.
            buffer.flip();

            // buffer is the ByteBuffer that wrap outputBytes, which is "Hello World!" as byte array.  The read()
            // method returns the number of bytes from reading buffer.
            long numBytesRead = channel.read(buffer);

            // Print out outputBytes in String format.
            if(buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
            }


            /*
            // Relative Read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            // intBuffer is ByteBuffer, invokes getInt() to read an int value.
            System.out.println(intBuffer.getInt()); // Get the first int.
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer); // Get the second int.
            intBuffer.flip();
            System.out.println(intBuffer.getInt());
             */

            // Absolute Read
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            // Absolute get method for reading an int value, index is 0.
            System.out.println(intBuffer.getInt(0));
            intBuffer.flip();
            numBytesRead = channel.read(intBuffer);
            intBuffer.flip();
            System.out.println(intBuffer.getInt(0));
            System.out.println(intBuffer.getInt());

            // Close the IO streams.
            channel.close();
            ra.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
