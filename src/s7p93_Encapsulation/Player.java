package s7p93_Encapsulation;

public class Player {

    /* Instance variables can be change in other classes, because access modifier is set to public.  */
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("Player knock out");
            // Reduce number of lives remaining ofr the player
        }
    }

    public int healthRemaining() {
        return this.health;
    }

}
