package s8p116_LinkedList_Part_3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

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


    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()) {
            /* Use compareTo() to compare current element of iteration (stringListIterator.next()) with newCity.  */
            int comparison = stringListIterator.next().compareTo(newCity);
            /* If newCity is already in LinkedList, compareTo will return 0, and thus, newCity will not be added.  */
            if (comparison == 0) {
                System.out.println(newCity + " is already included as a destination.  ");
                return false;
            }
            /* If newCity alphabetically comes before the current city, compareTo() method will result in > 0.
            For example, "Brisbane".compareTo("Adelaide") would result in a positive number.  This means Adelaide will
            be added before Brisbane.  */
            else if (comparison > 0) {
                /* Go back to previous entry then add newCity.  */
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            }
            /* If newCity alphabetically comes after the current city, compareTo() method will result in < 0.
             * For example, "Brisbane".compareTo("Canberra") would result in a negative number.  */
            // else if (comparison < 0) {
            else {
                // Move on next city.
            }
        }

        /* Add newCity at the end if I go through an entire list without finding a suitable point to insert the entry.  */
        stringListIterator.add(newCity);
        return true;
    }


    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        /* Use goingForward as a flag because there is a problem with the visit() method.  I start with being in
        Adelaide.  If I choose 1 (go to next city), I will be in Alice Spring.  Then If I choose 1 again, I will
        be in Brisbane.  However, if I choose 2 for the first time, I remain in Brisbane.  Only after I choose 2
        for a second time, I visit Alice Springs.  */
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();

        /* Checks if the LinkedList is empty.  */
        if(cities.isEmpty()) {
            System.out.println("No cities in the itinerary.  ");
        }
        else {
            /* Visit the first city if the LinkedList is not empty.  */
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                /* Quit holiday.  */
                case 0:
                    System.out.println("Holiday (Vacation) is over!  ");
                    quit = true;
                    break;
                /* Travel to next destination.  */
                case 1:
                    /* If goingForward is not true and my input is 1.  Go to the next item if there is a next item,
                    * then set goingForward to true.  */
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    /* If there is next item in the cities LinkedList...  */
                    if(listIterator.hasNext()) {
                        /* Get the next item in the cities LinkedList.  */
                        System.out.println("Now visiting " + listIterator.next());
                    }
                    else {
                        System.out.println("Reached the end of the list.  ");
                    }
                    break;
                /* Travel to previous destination.  */
                case 2:
                    /* If goingForward is true and my input is 2.  Go to the previous item if there is a previous item,
                     * then set goingForward to false.  */
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    /* If there is previous item in the cities LinkedList...  */
                    if(listIterator.hasPrevious()) {
                        /* Get the previous item in the cities LinkedList.  */
                        System.out.println("Now visiting " + listIterator.previous());
                    }
                    else {
                        System.out.println("We are at the start of the list.  ");
                    }
                    break;
                /* Invoke printMenu().  */
                case 3:
                    printMenu();
                    break;
            }
        }
    }


    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                            "1 - go to next city\n" +
                            "2 - go to previous city\n" +
                            "3 - print menu options");
    }


    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();

        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);

        visit(placesToVisit);

    }

}
