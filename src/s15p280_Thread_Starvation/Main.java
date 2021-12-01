package s15p280_Thread_Starvation;

public class Main {

    /* The lock Object is static, which means there is only one instance of the object.  All threads will be competing
    * for that one instance's lock.  */
    private static Object lock = new Object();


    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 2");

        /* setPriority():  A method used to change the method's priority from 1 to 10.  5 is default, 1 is minimum,
        * 10 is maximum.  */
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                synchronized (lock) {
                    System.out.format(threadColor + "%s:  runCount = %d\n", Thread.currentThread().getName(), runCount++);
                }
            }
        }
    }

}
