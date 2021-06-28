package s9p125_Interfaces_Challenge_Answer;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim);
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);
        tim.setWeapon("Stormbringer");
        saveObject(tim);
        // loadObject(tim); // Call the loadObject() method, which calls the readValue() method.
        System.out.println(tim);

        ISaveable werewolf = new Monster("Werewolf", 20, 40);

        /* Despite Monster implements ISaveable, ISaveable interface has no getStrength() method, so the method
        * in Monster is not being invoked.  */
        // werewolf.getStrength();

        /* Now this statement is valid, because I cast werewolf to Monster type, and Monster has getStrength() method.  */
        System.out.println("Strength = " + ((Monster) werewolf).getStrength());

        System.out.println(werewolf);
        saveObject(werewolf);
    }


    /* Returns a list of saved String.  */
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    /* Start adding on index 0 (name), next time I choose option 1 again, I add on value to index 1
                    * (hitPoints), then the next time I choose option 1 again, I add value to index 2 (strength).  */
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }


    /* Display a message that the fields are store in the list.  ISaveable is a class that can represent either
    * the Player type object or the Monster type object.
    * objectToSave.write() returns a List, objectToSave.write().size() is the size of the list.  */
    public static void saveObject(ISaveable objectToSave) {
        /* Print out each object's attributes by iterating through a List (values) of the object.  */
        for (int i = 0; i < objectToSave.write().size(); i++) {
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }
    }


    /* Call the readValues() method, then return an ArrayList and sagve it in values ArrayList.
    * Then use objectToRoad to invoke the read() and pass values as parameter.  The read() method will set the
    * values of the fields based on the ArrayList input as the result.  */
    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }

}