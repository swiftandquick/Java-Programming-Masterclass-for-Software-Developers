package s15p282_Fair_Locks_and_Live_Locks_b;

public class SharedResource {

    private Worker owner;


    public SharedResource(Worker owner) {
        this.owner = owner;
    }


    public Worker getOwner() {
        return owner;
    }


    public void setOwner(Worker owner) {
        this.owner = owner;
    }

}
