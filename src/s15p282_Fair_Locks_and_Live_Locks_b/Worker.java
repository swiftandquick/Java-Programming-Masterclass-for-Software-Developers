package s15p282_Fair_Locks_and_Live_Locks_b;

public class Worker {

    private String name; // Name of Worker.
    private boolean active; // Status of Worker.


    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }


    public String getName() {
        return name;
    }


    public boolean isActive() {
        return active;
    }


    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        while(active) {
            /* If sharedResource's owner is not the same Worker object...  */
            if(sharedResource.getOwner() != this) {
                try {
                    /* Wait for 0.01 seconds until the thread is awaken.  */
                    wait(10);
                }
                catch(InterruptedException e) {
                }
                continue;
            }
            /* If otherWorker (Worker)'s active value is true...  */
            if(otherWorker.isActive()) {
                System.out.println(getName() + ":  give resource to the worker " + otherWorker.getName());
                /* Set owner of sharedResource to other owner because this (Worker) give resource to otherWorker.  */
                sharedResource.setOwner(otherWorker);
                continue;
            }
            System.out.println(getName() + ":  working on the common resource.  ");
            /* Set active to false.  */
            active = false;
            /* Set the owner (SharedResource's instance variable) to otherWorker again.  */
            sharedResource.setOwner(otherWorker);
        }
    }

}
