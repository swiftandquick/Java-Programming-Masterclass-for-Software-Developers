package s7p92_Composition_Part_2_Challenge_Exercise_Try;

public class Main {

    public static void main(String[] args) {
        Door door = new Door(7, 4, "steel");
        Light light = new Light(1000, "yellow");
        Wall wall = new Wall (21, 9, "white");

        Room room = new Room(wall, door, light);

        /* Use room object to invoke the enter() method in the Room class.  */
        room.enter();

        /* Use getWall() method to access the wall object (attribute) of the room object, then use that object
        * to invoke getLength() and getWidth() methods to get the length and width.  */
        System.out.println("Height of Wall:  " + room.getWall().getHeight() + " ft.  ");
        System.out.println("Length of Wall:  " + room.getWall().getLength() + " ft.  ");
    }

}
