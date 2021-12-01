package s15p265_Threads;

import static s15p265_Threads.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.  ");

        /* Create a Thread object.  */
        Thread anotherThread = new AnotherThread();
        /* Change the name of the Thread object anotherThread to "== Another Thread ==".  */
        anotherThread.setName("== Another Thread ==");
        /* start():  Invoke the run() method.  */
        anotherThread.start();

        /* Following line will call the main thread, that's why I should call start() to invoke run().  */
        // anotherThread.run();

        /* I can create a thread via an anonymous class, with run() inside the class and invoke start() at the ending
        brace.  Because this is a thread that runs in the background, the thread is run after the main thread.  Which
        means "Hello again from the main thread.  " will be printed before "Hello from the anonymous class thread.  " */
        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from from the anonymous class thread.  ");
            }
        }.start();

        /* Create a Thread object based on MyRunnable class, a class that implements Runnable interface.  */
        Thread myRunnableThread = new Thread(new MyRunnable()) {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class' implementation of run().  ");
                try {
                    /* join():  It will put the current thread on wait until the thread on which it is called is dead.
                    If thread is interrupted then it will throw InterruptedException.  In this case, myRunnableThread
                    will run after anotherThread is dead.  */
                    anotherThread.join();
                    /* Waits 2 seconds (2000 milliseconds) then go back to myRunnableThread, but anotherThread ia also
                    running in the background.  */
                    // anotherThread.join(2000);
                    System.out.println(ANSI_RED + "AnotherThread terminated or timed out, so I'm running again.  ");
                }
                catch(InterruptedException e) {
                    System.out.println(ANSI_RED + "I couldn't wait after all.  I was interrupted.  ");
                }
            }
        };
        /* Invoke the run() method in MyRunnable class.  */
        myRunnableThread.start();

        /* If the targeted thread has been waiting (by calling wait() or sleep()), it will be interrupted and stops
        waiting, then receive InterruptedException.  In this case, anotherThread's run() method no longer sleeps,
        but rather receive InterruptedException.  */
        // anotherThread.interrupt();

        /* If I didn't specified the color, use the color of the last String output, which is blue, so I specified
        * the color to be purple.  */
        System.out.println(ANSI_PURPLE + "Hello again from the main thread.  ");

        /* Using a subclass of thread means we have to define the run method once, but we can't reuse the same instance.
        * So the follow line cause an exception.  */
        // anotherThread.start();
    }

}
