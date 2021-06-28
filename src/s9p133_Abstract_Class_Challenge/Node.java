package s9p133_Abstract_Class_Challenge;

/* Extend to abstract class.  */
public class Node extends ListItem {

    public Node(Object value) {
        super(value);
    }


    /* Override methods from abstract method.  */
    @Override
    ListItem next() {
        /* I can use instance variables from ListItem method because Node is a child class.  */
        return rightLink;
    }


    @Override
    ListItem setNext(ListItem item) {
        rightLink = item;
        return rightLink;
    }


    @Override
    ListItem previous() {
        return leftLink;
    }


    @Override
    ListItem setPrevious(ListItem item) {
        leftLink = item;
        return leftLink;
    }


    @Override
    int compareTo(ListItem item) {
        /* If item is not null.  */
        if(item != null) {
            /* Compare String value of Object (from superclass) and String value of parameter item.
            * If String value of value (Object) is alphabetically after the String value of item (ListItem), for
            * example, if value is "b" and item is "a", return a positive number.  However, if value is "a" and
            * item is "b", return a negative number.  If String values of both value item is "a", return 0.  */
            return((String) super.getValue()).compareTo((String) item.getValue());
        }
        else {
            /* -1 is a negative number.  The compareTo() method will also return negative number if value's String value
            is alphabetically before item's String value, for example, value is "a", and item is "b".  */
            return -1;
        }
    }

}