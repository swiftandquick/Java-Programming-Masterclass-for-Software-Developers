package s14p250_Absolute_and_Relative_Reads;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("src/s14p250_Absolute_and_Relative_Reads/data.dat");
            FileChannel binChannel = binFile.getChannel()) {

            // Encode a String into a sequence of array and store the bytes in a byte array.
            byte[] outputBytes = "Hello World!".getBytes();

            // Allocate a buffer, number of bytes equal to size of outputBytes array.
            ByteBuffer buffer = ByteBuffer.allocate(outputBytes.length);
            // Relative bulk put method, buffer is ByteBuffer.  Copy (write) contents of outputBytes into buffer.
            buffer.put(outputBytes);

            buffer.flip();

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

            // Create a RandomAccessFile that can read and write synchronously.
            RandomAccessFile ra = new RandomAccessFile("src/s14p250_Absolute_and_Relative_Reads/data.dat",
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
                // System.out.println("byte buffer = " + new String(outputBytes));
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
