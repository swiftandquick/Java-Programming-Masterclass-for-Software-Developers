package s4p45_Statements_Whitespace_and_Indentation_Code_Organization;

public class Main {

    public static void main(String[] args) {
        // The whole line is a statement.
        int myVariable = 50;
        myVariable++;
        myVariable--;
        System.out.println("This is a test.  ");

        /* The three lines below is one statement.  */
        System.out.println("This is " +
                " another" +
                " still more.");

        /* Statements are separated by semicolons in Java, there are 3 statements in one line below.  */
        int anotherVariable = 50; myVariable--; System.out.println("This is another one.  ");
    }

}
