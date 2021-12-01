package s15p282_Fair_Locks_and_Live_Locks_b;

public class Main {

    public static void main(String[] args) {

        /* Create 2 Worker instances.  */
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(worker1);

        /* Create a thread for each instance and start the thread.  */
        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.work(sharedResource, worker1);
            }
        }).start();
    }

}
