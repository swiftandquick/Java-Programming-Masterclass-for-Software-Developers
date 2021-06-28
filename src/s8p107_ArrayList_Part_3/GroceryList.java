package s8p107_ArrayList_Part_3;

import java.util.ArrayList;

public class GroceryList {

    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>();


    /* Getter */
    public ArrayList<String> getGroceryList() {
        return groceryList;
    }


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


    public void modifyGroceryItem(String currentItem, String newItem) {
        /* Find the index of currentItem on ArrayList.  */
        int position = findItem(currentItem);
        /* If the index is found, which means findItem returns a number >= 0.  */
        if (position >= 0) {
            /* Call the overloaded method, pass in position and newItem as arguments.  Replace currentItem with
            * newItem on the currentItem's index (position).  */
            modifyGroceryItem(position, newItem);
        }
    }


    /* Set or replace item of a specified position.  */
    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position + 1) + " has been modified.  ");
    }


    /* Check and see if the item exists, if it does, call the overloaded method removeGroceryItem and pass in the
    * index of the item as argument to remove the specified item.  */
    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }


    /* Remove item of a specified position.  */
    private void removeGroceryItem(int position) {
        String theItem = groceryList.get(position);
        groceryList.remove(position);
    }


    private int findItem(String searchItem) {
        // Return the index of the searched item.
        return groceryList.indexOf(searchItem);
    }


    /* Call findItem() to check if item is in the ArrayList.  */
    public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if (position >=0) {
            return true;
        }
        else {
            return false;
        }
    }


    /*
    public static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList.toArray(myArray);
    }
     */

}
