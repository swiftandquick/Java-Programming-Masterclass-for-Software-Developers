package s8p116_LinkedList_Part_2;

import java.util.Iterator;
import java.util.LinkedList;

public class Demo {

    private static void printList(LinkedList<String> linkedList) {
        /* Set up an iterator to iterate through the LinkedList.  */
        Iterator<String> i = linkedList.iterator();
        /* Check if there is a next element, or if the LinkedList is currently pointing to an existing next element.
         If there is, hasNext() returns true and while loop continues.  */
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("================");
    }


    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        placesToVisit.add("Sydney");
        placesToVisit.add("Melbourne");
        placesToVisit.add("Brisbane");
        placesToVisit.add("Perth");
        placesToVisit.add("Canberra");
        placesToVisit.add("Adelaide");
        placesToVisit.add("Darwin");

        printList(placesToVisit);

        /* Insert Alice Springs between Sydney and Melbourne.  */
        placesToVisit.add(1, "Alice Springs");

        printList(placesToVisit);

        /* Remove index 4, which is Perth.  Canberra is now in index 4.  Brisbane now points to Canberra.  */
        placesToVisit.remove(4);

        printList(placesToVisit);
    }

}
