package s15p278_ArrayBlockingQueue_Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static s15p273_The_Java_Util_Concurrent_Package.Main.EOF;

public class Main {

    public static final String EOF = "EOF";


    public static void main(String[] args) {
        /* ArrayBlockingQueue:  A bounded blocking queue backed by an array.  This queue orders elements FIFO (first-in-
        first-out).  Set the capacity to 6.  */
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        /* Create an ExecutorService object, and use it to create a fixed thread pool size of 5.  */
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        /* Pass the task objects to the pool to execute.  */
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        /* Future:  A class that represents a future result of an asynchronous computation, a result that will
        eventually appear in the Future after the processing is complete.
        Use executorService (ExecutorService object) to call submit method, pass in Callable<String> as argument.
        Callable:  An interface that is designed for to return a result, it's designed for classes whose instances
        are potentially executed by another thread.  */
        Future<String> future = executorService.submit(new Callable<String>()   {
           /* Computes a result, or throws an exception if unable to do so.  */
            @Override
           public String call() throws Exception {
               System.out.println(ThreadColor.ANSI_BLUE + "I'm being printed in the Callable class.  ");
               return "This is the callable result.  ";
           }
        });

        try {
            /* Retrieves the result.  The method will block the execution until the task is complete.  */
            System.out.println(future.get());
        }
        /*  ExecutionException:  Exception thrown when attempting to retrieve the result of a task that aborted by
        throwing an exception.  */
        catch(ExecutionException e) {
            System.out.println("Something went wrong.  ");
        }
        /* InterruptedException:  Thrown when a thread is waiting, sleeping, or otherwise occupied, and the thread is
        interrupted, either before or during the activity.  */
        catch(InterruptedException e) {
            System.out.println("Thread running the task was interrupted.  ");
        }

        /* Shut down the ExecutorService when we no longer need it.  If I don't shut it down, the application is
        * going to remain live even after main thread is terminated.  */
        executorService.shutdown();
    }

}


class MyProducer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;


    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5" };

        for(String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                /* Add each String variable of nums array in buffer list.  */
                buffer.put(num);
                /* Thread sleeps for up to 1 second.  */
                Thread.sleep(random.nextInt(1000));
            }
            catch(InterruptedException e) {
                System.out.println("Producer was interrupted.  ");
            }
        }

        System.out.println(color + "Adding EOF and existing...");
        try {
            buffer.put("EOF");
        }
        catch(InterruptedException e) {
            System.out.println("Producer was interrupted.  ");
        }
    }

}


class MyConsumer implements Runnable {

    private ArrayBlockingQueue<String> buffer;
    private String color;


    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {

        int counter = 0;

        while(true) {
            synchronized (buffer) {
                try {
                    /* If buffer doesn't contain any elements, stops current iteration and continues to next iteration.
                     * Keep checking until the buffer isn't empty.  */
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    /* peek():  Retrieves, but does not remove, the head of this queue, or returns null if this queue
                    is empty.  Checks if the head is "EOF".  */
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    }
                    /* If buffer is not empty and is not EOF, retrieve and remove head of buffer (ArrayBlockingQueue).  */
                    else {
                        System.out.println(color + "Removed " + buffer.take());
                    }
                }
                catch(InterruptedException e){
                }
            }
        }
    }

}