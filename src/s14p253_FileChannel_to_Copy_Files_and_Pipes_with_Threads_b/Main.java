package s14p253_FileChannel_to_Copy_Files_and_Pipes_with_Threads_b;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class Main {

    public static void main(String[] args) {
        try {
            // A pair of channels that implements a unidirectional pipe.  A pipe consists of a pair of channels:  A
            // writable sink channel and a readable source channel.  Once some bytes are written to the sink channel
            // they can be read from source channel in exactly the order in which they were written.
            // Open a pipe.
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        // Pipe.SinkChannel:  A channel representing the writable end of a Pipe.
                        // sink():  Returns the Pipe's sink channel.
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        // Allocate 56 bytes to ByteBuffer.
                        ByteBuffer buffer = ByteBuffer.allocate(56);
                        // Get the current time 10 times.
                        for(int i = 0; i < 10; i++) {
                            String currentTime = "The time is:  " + System.currentTimeMillis();
                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            // hasRemaining():  Tells whether there are any elements between the current position and
                            // the limit.
                            // While 56 bytes is not all used up yet, since I allocated 56 bytes to buffer (ByteBuffer).
                            while(buffer.hasRemaining()) {
                                // Write the string from the buffer (ByteBuffer) into sinkChannel (SinkChannel).
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            // Put the thread to sleep for 0.1 seconds.
                            Thread.sleep(100);
                        }
                    }
                    catch(Exception e) {

                    }
                }
            };

            Runnable reader = new Runnable() {
                @Override
                public void run() {
                    try {
                        // Pipe.SourceChannel:  A channel representing the readable end of a Pipe.
                        // source():  Returns this pipe's source channel.
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        // Allocate 56 bytes to ByteBuffer.
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i = 0; i < 10; i++) {
                            // Write the string from the buffer (ByteBuffer) into sourceChannel (SourceChannel).
                            // Return the number of bytes read.
                            int bytesRead = sourceChannel.read(buffer);
                            // Size of timeString is equal to bytesRead.
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            // Relative get method.
                            buffer.get(timeString);
                            // Convert byte array timeString to String.
                            System.out.println("Reader Thread:  " + new String(timeString));
                            buffer.flip();
                            // Put thread sleep for 0.1 seconds.
                            Thread.sleep(100);
                        }
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };

            // Start the writer thread and writer reader.
            new Thread(writer).start();
            new Thread(reader).start();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}
