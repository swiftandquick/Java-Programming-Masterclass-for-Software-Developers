package s14p252_Writing_Sequentially;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

    public static void main(String[] args) {
        try(FileOutputStream binFile = new FileOutputStream("src/s14p252_Writing_Sequentially/data.dat");
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
            RandomAccessFile ra = new RandomAccessFile("src/s14p252_Writing_Sequentially/data.dat",
                    "rwd");
            FileChannel channel = ra.getChannel();

            // Allocate enough bytes to contain an int.
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            // Put channel to int3Pos' position (36).
            channel.position(int3Pos);
            // Read the int 1000.
            channel.read(readBuffer);
            readBuffer.flip();
            // Get the int 1000.
            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();

            // Put channel to intPos' position (16).
            channel.position(int2Pos);
            // Read the int -98765.
            channel.read(readBuffer);
            readBuffer.flip();
            // Get the int -98765.
            System.out.println("int2 = " + readBuffer.getInt());
            readBuffer.flip();

            // Put channel to intPos' position (12)
            channel.position(int1Pos);
            // Read the int 245.
            channel.read(readBuffer);
            readBuffer.flip();
            // Get the int 245.
            System.out.println("int1 = " + readBuffer.getInt());

            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            // Write 245 to data.dat.
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);

            // Write -98765 to data.dat.
            intBuffer.flip();
            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);

            // Write 1000 to data.dat.
            intBuffer.flip();
            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            // Write "Hello, World!" to data.dat.
            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));

            // Write "Nice to meet you" to data.dat.
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
