package s15p265_Threads;

/* Import a variable ANSI_BLUE from class ThreadColor.  */
import static s15p265_Threads.ThreadColor.ANSI_BLUE;

/* I can customize a thread by making a class the subclass of Thread class, then override the run method.  */
public class AnotherThread extends Thread {

    /* run() can be called by using calling start() or run().  */
    @Override
    public void run() {
        /* Change the color of the String.  Returns the name of the current thread.  */
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try {
            // Put thread to sleep for 3 seconds (3000 milliseconds).
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            // It will print the "Another thread woke me up.  " after sleep ended.
            System.out.println(ANSI_BLUE + "Another thread woke me up.  ");
            // Use to terminate anotherThread instance.
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake.  ");
    }

}
