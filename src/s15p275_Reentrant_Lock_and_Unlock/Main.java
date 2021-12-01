package s15p275_Reentrant_Lock_and_Unlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static s15p273_The_Java_Util_Concurrent_Package.Main.EOF;

public class Main {

    public static final String EOF = "EOF";


    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        /* ReentrantLock:  A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit
        monitor lock accessed using synchronized methods and statements, but with extended capabilities.
        The lock is reentrant if its thread is already holding a ReentrantLock when it reaches the code that requires
        the same lock, it can continue executing.  It doesn't have to obtain the lock again.   */
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN, bufferLock);

        /* Start the threads producer, consumer1, and consumer2.  */
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}



class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;


    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5" };

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                /* Synchronized adding String elements to buffer.  */
                /* Using ReentrantLock with lock() and unlock() method can avoid thread interference.
                * Acquires the lock.  */
                bufferLock.lock();
                try {
                    /* Add each String variable of nums array in buffer list.  */
                    buffer.add(num);
                }
                finally {
                    /* Releases the lock.  */
                    bufferLock.unlock();
                }
                /* Thread sleeps for up to 1 second.  */
                Thread.sleep(random.nextInt(1000));
            }
            catch(InterruptedException e) {
                System.out.println("Producer was interrupted.  ");
            }
        }

        System.out.println(color + "Adding EOF and existing...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        }
        finally {
            bufferLock.unlock();
        }
    }

}



class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;


    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }


    public void run() {

        int counter = 0;

        while(true) {
            /* Acquires the lock only if it is not held by another thread at the time of invocation.
            * Returns true if the lock is available.  */
            if(bufferLock.tryLock()) {
                try {
                    /* If buffer doesn't contain any elements, stops current iteration and continues to next iteration.
                     * Keep checking until the buffer isn't empty.  */
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    /* Reset counter to 0 if there is a lock.  */
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;
                    /* If buffer's first index (index 0) is EOF, break out of loop.  */
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    }
                    /* If buffer is not empty and is not EOF, remove first index (index 0) of buffer.  */
                    else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                }
                finally {
                    bufferLock.unlock();
                }
            }
            else {
                /* Increment counter by 1 if there's no lock.  */
                counter++;
            }
        }
    }

}