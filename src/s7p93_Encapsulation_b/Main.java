package s7p93_Encapsulation_b;

public class Main {

    public static void main(String[] args) {

        /* Call the constructor to create an EnhancedPlayer object.  200 is not within 0 and 100, and the default
        * hitpoints value is 100, so when I call getHealth(), the value 100 is returned.  */
        EnhancedPlayer player = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("Initial health is " + player.getHealth());
    }

}
