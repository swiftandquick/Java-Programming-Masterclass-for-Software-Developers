package s8ce44_Mobile_Phone;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        myContacts = new ArrayList<Contact>();
    }


    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact already existed.  ");
            return false;
        }
        else {
            myContacts.add(contact);
            return true;
        }
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactIndex = findContact(oldContact);
        if (oldContactIndex < 0) {
            System.out.println(oldContact.getName() + " doesn't exist.  ");
            return false;
        }
        else if (findContact(newContact) >= 0) {
            System.out.println(newContact.getName() + " already existed.  ");
            return false;
        }
        else {
            myContacts.set(oldContactIndex, newContact);
            System.out.println(oldContact.getName() + " is replaced by " + newContact.getName() + ".  ");
            return true;
        }
    }


    public boolean removeContact(Contact contact) {
        int contactIndex = findContact(contact);
        if (contactIndex < 0) {
            System.out.println(contact + " doesn't exist.  ");
            return false;
        }
        else {
            myContacts.remove(contactIndex);
            System.out.println("Successfully remove " + contact.getName() + ".  ");
            return true;
        }
    }


    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }


    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name) {
        int contactIndex = findContact(name);
        if (contactIndex < 0) {
            return null;
        }
        else {
            return myContacts.get(contactIndex);
        }
    }


    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                                myContacts.get(i).getName() + " -> " +
                                myContacts.get(i).getPhoneNumber());
        }
    }

}
