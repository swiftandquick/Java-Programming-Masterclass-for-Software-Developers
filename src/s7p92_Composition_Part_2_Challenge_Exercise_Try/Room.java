package s7p92_Composition_Part_2_Challenge_Exercise_Try;

public class Room {

    private Wall wall;
    private Door door;
    private Light light;


    public Room(Wall wall, Door door, Light light) {
        this.wall = wall;
        this.door = door;
        this.light = light;
    }


    public Wall getWall() {
        return wall;
    }


    public void enter() {
        /* Use door object to invoke the open() method in the Room class.  */
        door.open();
        System.out.println("Enter the room...  ");
        /* Use light object to invoke the turnOn() method in the Room class.  */
        light.turnOn();
    }

}
