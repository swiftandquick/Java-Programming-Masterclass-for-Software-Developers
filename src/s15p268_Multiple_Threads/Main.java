package s15p268_Multiple_Threads;

public class Main {

    public static void main(String[] args) {
        /* Create a Countdown object.  */
        Countdown countdown = new Countdown();

        /* Create a CountdownThread object, CountdownThread is a subclass of the Thread.  */
        CountdownThread t1 = new CountdownThread(countdown);
        /* Set the name of the thread.  */
        t1.setName("Thread 1");
        CountdownThread t2 = new CountdownThread(countdown);
        t2.setName("Thread 2");

        /* Invoke the run() method in CountdownThread.  */
        t1.start();
        t2.start();
    }

}



class Countdown {

    private int i;


    /* Synchronized method.  I want this whole method to run before another thread gets access.  In this case, thread
    * 1 finishes running doCountdown() before thread 2 starts.  This prevents race condition.  */
    // public synchronized void doCountdown() {
    public void doCountdown() {
        String color;

        switch(Thread.currentThread().getName()) {
            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;
            default:
                color = ThreadColor.ANSI_GREEN;
        }

        /* A second way to prevent a race condition is to synchronize a block of statements rather than an entire method.  */
        synchronized(this) {
            for(i = 10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ":  i = " + i);
            }
        }
    }

}



class CountdownThread extends Thread {

    private Countdown threadCountdown;


    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }


    public void run() {
        threadCountdown.doCountdown();
    }

}