package s15p271_Producer_and_Consumer;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Message message = new Message();
        /* Invoke the run() method in Writer and Reader class.  */
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }

}



class Message {

    private String message;
    private boolean empty = true;


    /* Synchronized read() and write() because when a thread runs one of these method, we don't want another thread
    to be able to run either method. We don't want the reader thread to run while the writer thread is writing a message
    and vice versa.
    Synchronized method to read the message.  */
    public synchronized String read() {
        /* Iterate while loop until there is a message.  */
        while(empty) {
            try {
                /* wait():  Causes current thread to wait until another thread invokes the notify() method or the
                notifyAll() method for this object.  wait(0) has the same function.  */
                wait();
            }
            catch(InterruptedException e) {
            }
        }
        empty = true;
        /* notifyAll():  Wakes up all threads that are waiting on this object's monitor.  A thread waits on an object's
        monitor by calling one of the wait methods.  */
        notifyAll();
        return message;
    }


    /* Synchronized method to write the message.  */
    public synchronized void write(String message) {
        /* Iterate while loop until message is empty.  */
        while(!empty) {
            try {
                wait();
            }
            catch(InterruptedException e) {
            }
        }
        empty = false;
        notifyAll();
        this.message = message;
    }

}



class Writer implements Runnable {

    private Message message;


    public Writer(Message message) {
        this.message = message;
    }


    public void run() {
        String messages[] = {
                "Humpty Dumpty sat on a wall.  ",
                "Humpty Dumpty had a great fall.  ",
                "All the king's horses and all the king's men.  ",
                "Couldn't put Humpty together again.  "
        };

        Random random = new Random();

        for(int i = 0; i < messages.length; i++) {
            /* Call the synchronized write() method in Message class.  */
            message.write(messages[i]);
            try {
                /* Sleep for a random duration, up to 2 seconds.  */
                Thread.sleep(random.nextInt(2000));
            }
            catch(InterruptedException e) {
            }
        }
        message.write("Finished!  ");
    }

}



class Reader implements Runnable {

    private Message message;


    public Reader(Message message) {
        this.message = message;
    }


    public void run() {
        Random random = new Random();
        /* Retrieve a message from read() method in Message class.  */
        for(String latestMessage = message.read(); !latestMessage.equals("Finish!  ");
            latestMessage = message.read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            }
            catch(InterruptedException e) {
            }
        }
    }
}