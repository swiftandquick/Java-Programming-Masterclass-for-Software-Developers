package s6p83_Reference_VS_Object_VS_Instance_VS_Class;

public class Main {

    public static void main(String[] args) {

        /* Creates a new instance of the House class.  Remember House is a blueprint, and we are assigning
        * it to the blueHouse variable.  In other words, it's a reference to the object's memory.  */
        House blueHouse = new House("blue");

        /* Creates another reference to the same object memory.  Here, we have two references point to
        * the same object in memory.  There is still one house, but two references to that one object.
        * In other words, we have two pieces of paper with the physical address of where the house is built.  */
        House anotherHouse = blueHouse;

        /* Next we have two println statements that print the blueHouse color and anotherHouse color.
        * Both will print "blue" since we have two references to the same object.  */
        System.out.println(blueHouse.getColor()); // blue
        System.out.println(anotherHouse.getColor()); // blue

        /* Both blueHouse and anotherHouse have the same color now (yellow).  Remember we have two references that
        point to the same object in memory.  Once we change the color of one, both references still point to the same
        object.  In real world example, there is still just one physical house at that one address even though we
          have written the same address on two pieces of paper.  */
        anotherHouse.setColor("yellow");

        /* Here we have two println statements that are printing the color.  Both now print "yellow" since we still
        * have two references point to the same object in memory.  */
        System.out.println(blueHouse.getColor()); // yellow
        System.out.println(anotherHouse.getColor()); // yellow

        /* Create another new instance of the House class and set the color to "green".  Now we have two objects in memory
        but we have three references, which are blueHouse, anotherHo9use, and greenHouse.  The variable (reference) greenHouse
        points to a different object in memory, but blueHouse and anotherHouse point to the same object in memory.  */
        House greenHouse = new House("green");

        /* Here we assign greenHouse to anotherHouse.  In other words we are dereferencing anotherHouse.  It will not point
        * to a different object in memory.  Before it was pointing to a house that had "yellow" color, now it points to the
        * house that has the "green" color.  In this scenario we still have three references and two objects in memory but
        * blueHouse to points to one object (with "yellow" color) while anotherHouse and greenHouse point to the same object
        * in memory (with "green" color).  */
        anotherHouse = greenHouse;

        /* First print "yellow" since the blueHouse variable (reference) points to the object in memory that has the "yellow"
        * color, while the next two lines will print "green" since both anotherHouse and greenHouse point to the same object
        * in memory.  */
        System.out.println(blueHouse.getColor()); // yellow
        System.out.println(greenHouse.getColor()); // green
        System.out.println(anotherHouse.getColor()); // green

    }

}
