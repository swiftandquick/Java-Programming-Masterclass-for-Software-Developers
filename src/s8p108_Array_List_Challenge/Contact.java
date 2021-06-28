package s8p108_Array_List_Challenge;

public class Contact {

    private String name;
    private String phoneNumber;


    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    /* Create a new contact by setting local variables from parameter equal to the instance variables counterpart.
    * Contact class is a static method, I can use Contact class rather than an object to invoke this method.  */
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

}
