package s8p105_List_and_ArrayList_Part_1_b;

import java.util.ArrayList;

public class GroceryList {

    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>();


    public void addGroceryItem(String item) {
        /* Adds a String to ArrayList groceryList.  */
        groceryList.add(item);
    }


    /* Print the entire grocery list.  */
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }


    /* Set or replace item of a specified position.  */
    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.  ");
    }


    /* Remove item of a specified position.  */
    public void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }


    public String findItem(String searchItem) {
        /* Check to see if item exists in groceryList.  */
        boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        /* If indexOf() method returns a number >= 0, that means the item exists in the ArrayList.  */
        if (position >= 0) {
            /* Return the item of the given position.  */
            return groceryList.get(position);
        }
        return null;
    }

}
