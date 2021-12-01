package s15p279_Deadlocks;

public class Main {

    /* Threads in the application are going to use these objects to synchronize.  */
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();


    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }


    /* Inner class Thread1 is a subclass of Thread.  */
    private static class Thread1 extends Thread {

        public void run() {
            /* Try to obtain the lock for the lock1 object.  */
            synchronized(lock1) {
                System.out.println("Thread 1:  Has lock1.  ");
                try {
                    /* If successful, sleep for 0.1 seconds.  */
                    Thread.sleep(100);
                }
                catch (InterruptedException e) {
                }
                System.out.println("Thread 1:  Waiting for lock2.  ");
                /* When the thread wakes up, try to obtain the lock for the lock2 object.  */
                synchronized(lock2) {
                    System.out.println("Thread 1:  Has lock1 and lock2.  ");
                }
                System.out.println("Thread 1:  Released lock2.  ");
            }
            System.out.println("Thread 1:  Released lock1.  Exiting...  ");
        }

    }


    /* Inner class Thread2 is a subclass of Thread.  */
    private static class Thread2 extends Thread {
        public void run() {
            /* Thread1 and Thread2 obtain locks in the same order, deadlock is resolved.  */
            synchronized (lock1) {
                System.out.println("Thread 2:  Has lock1.  ");
                try {
                    Thread.sleep(100);
                }
                catch(InterruptedException e) {
                }
                System.out.println("Thread 2:  Waiting for lock2.  ");
                synchronized(lock2) {
                    System.out.println("Thread 2:  Has lock1 and lock2.  ");
                }
                System.out.println("Thread 2:  Released lock2.  ");
            }
            System.out.println("Thread 2:  Released lock1.  Exiting...  ");
        }
    }

}

