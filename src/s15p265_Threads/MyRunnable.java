package s15p265_Threads;

import static s15p265_Threads.ThreadColor.ANSI_RED;

/* Runnable:  An interface that should be implemented by any class whose instances are intended to be executed by a thread.  */
public class MyRunnable implements Runnable {

   @Override
   public void run() {
       System.out.println(ANSI_RED + "Hello from MyRunnable's implementation of run().  ");
   }

}
