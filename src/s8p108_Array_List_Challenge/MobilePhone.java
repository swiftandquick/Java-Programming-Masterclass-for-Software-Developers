package s8p108_Array_List_Challenge;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        /* Instantiate the ArrayList.  */
        this.myContacts = new ArrayList<Contact>();
    }


    public boolean addNewContact(Contact contact) {
        /* contact.getName() returns the name (String) of the element.  findContact() method finds the index of the
        contact based on given name, if the index is >= 0, means that the contact already exist, so return false
        and don't add new contact.  */
        if(findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file.  ");
            return false;
        }
        else {
            /* If contact is not on file, add the contact.  */
            myContacts.add(contact);
            return true;
        }
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() + ", was not found.  ");
            return false;
        }
        /* Use findContact() method to check if newContact already exist.  If it already exist, it will not return
        * -1, so if that's the case, return false and do not update the contact list.  */
        else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName()
                                + " already exists.  Update was not successful.  ");
            return false;
        }
        else {
            /* Replace oldContact with newContact on the given position.  */
            this.myContacts.set(foundPosition, newContact);
            System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
            return true;
        }
    }


    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            System.out.println(contact.getName() + ", was not found.  ");
            return false;
        }
        else {
            /* Remove the element on the given position.  */
            this.myContacts.remove(foundPosition);
            System.out.println(contact.getName() + ", was deleted.  ");
            return true;
        }
    }


    /* Returns the index of the contact, if returned number >= 0, means contact exists.  */
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }


    private int findContact(String contactName) {
        /* Iterate through all indices of the ArrayList myContacts.  */
        for (int i = 0; i < this.myContacts.size(); i++) {
            /* Get the element of the specified index from myContacts.  */
            Contact contact = this.myContacts.get(i);
            /* Use getName() method to retrieve name value (String) of the contact object, if the name attribute of the
              contact object equals contactName, return current index (i).  */
            if(contact.getName().equals(contactName)) {
                return i;
            }
        }
        /* If contact with given name not found, return -1.  */
        return -1;
    }


    /* If contact exists, return the name of the contact.  */
    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        else {
            return null;
        }
    }


    /* Check for any records that match the name, then return Contact.  */
    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        else {
            return null;
        }
    }


    /* Print out all contacts' names and phone numbers.  */
    public void printContacts() {
        System.out.println("Contact List:");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " +
                                this.myContacts.get(i).getName() + " -> " +
                                this.myContacts.get(i).getPhoneNumber());
        }
    }

}
