package s15p273_The_Java_Util_Concurrent_Package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static s15p273_The_Java_Util_Concurrent_Package.Main.EOF;

public class Main {

    public static final String EOF = "EOF";


    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        /* Start the threads producer, consumer1, and consumer2.  */
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}



class MyProducer implements Runnable {

    private List<String> buffer;
    private String color;


    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5" };

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                /* Synchronized adding String elements to buffer.  */
                synchronized(buffer) {
                    /* Add each String variable of nums array in buffer list.  */
                    buffer.add(num);
                }

                /* Thread sleeps for up to 1 second.  */
                Thread.sleep(random.nextInt(1000));
            }
            catch(InterruptedException e) {
                System.out.println("Producer was interrupted.  ");
            }
        }

        System.out.println(color + "Adding EOF and existing...");
        synchronized(buffer) {
            buffer.add("EOF");
        }
    }

}



class MyConsumer implements Runnable {

    private List<String> buffer;
    private String color;


    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {
        while(true) {
            synchronized(buffer) {
                /* If buffer doesn't contain any elements, stops current iteration and continues to next iteration.
                 * Keep checking until the buffer isn't empty.  */
                if(buffer.isEmpty()) {
                    continue;
                }
                /* If buffer's first index (index 0) is EOF, break out of loop.  */
                if(buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                }
                /* If buffer is not empty and is not EOF, remove first index (index 0) of buffer.  */
                else {
                    System.out.println(color + "Removed " + buffer.remove(0));
                }
            }
        }
    }

}