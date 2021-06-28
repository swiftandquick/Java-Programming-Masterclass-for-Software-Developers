package s7p93_Encapsulation;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();

        /* Setting variables without constructor.  Instance variables are public so I can change their variables in
        * the Main class.  */
        player.name = "Tim";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());

        damage = 11;
        /* Instance variable health's value 200.  I can change instance variable directly.  */
        player.health = 200;
        player.loseHealth(damage);
        System.out.println("Remaining health = " + player.healthRemaining());
    }

}
