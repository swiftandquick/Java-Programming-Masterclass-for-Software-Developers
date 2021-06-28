package s8ce44_Mobile_Phone;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("0039-330-4404");


    private static void addNewContact() {
        System.out.println("Enter new contact name:  ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:  ");
        String phone = scanner.nextLine();
        /* Create an object called newContact by invoking the createContact (static) method.  */
        Contact newContact = Contact.createContact(name, phone);
        /* If addNewContact() method returns true, display a message that a contact has been added.  */
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added:  " + name + ", phone = " + phone + ".  ");
        }
        else {
            System.out.println("Cannot add, " + name + " already on file.  ");
        }
    }


    private static void updateContact() {
        System.out.println("Enter existing contact name:  ");
        String name = scanner.nextLine();
        /* Check if the contact can be found by calling queryContact method, if contact can't be found, it will return null.  */
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.  ");
        }
        else {
            /* Otherwise, enter the new contact's name and phoneNumber to create a new contact.  */
            System.out.print("Enter new contact name:  ");
            String newName = scanner.nextLine();
            System.out.print("Enter new contact phone number:  ");
            String newNumber = scanner.nextLine();
            Contact newContact = Contact.createContact(newName, newNumber);
            /* Replace the old contact with the new contact.  */
            if (mobilePhone.updateContact(existingContactRecord, newContact)) {
                System.out.println("Successfully updated record.  ");
            }
            else {
                System.out.println("Error updating record.  ");
            }
        }
    }


    private static void removeContact() {
        System.out.println("Enter existing contact name:  ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.  ");
        }
        else {
            /* If the contact is found, remove the contact.  */
            if (mobilePhone.removeContact(existingContactRecord)) {
                System.out.println("Successfully deleted.  ");
            }
            else {
                System.out.println("Error deleting contact.  ");
            }
        }
    }


    private static void queryContact() {
        System.out.println("Enter existing contact name:  ");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.  ");
        }
        else {
            /* Print out the name and phoneNumber of the contact.  */
            System.out.println("Name:  " + existingContactRecord.getName()
                                + "\nPhone Number:  " + existingContactRecord.getPhoneNumber());
        }
    }


    private static void startPhone() {
        System.out.println("Starting phone...  ");
    }


    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                            "1  - to print contacts\n" +
                            "2  - to add a new contact.  \n" +
                            "3  - to update an existing contact\n" +
                            "4  - to remove an existeing contact\n" +
                            "5  - query if an existing contact exists\n" +
                            "6  - to print a list of available actions.  ");
        System.out.println("Choose your action:  ");
    }


    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();

        while(!quit) {
            System.out.println("\nEnter action:  (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0:
                    System.out.println("\nShutting down...  ");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }

    }

}
