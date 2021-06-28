package s10p137_Our_Generics_Class_Part_2;

import java.util.ArrayList;

/* Generic class that has a generic variable T.  Parameter extends Player, means Player is upper bound of T.
* Now T can only take arguments that are object types of Player or one of Player’s subclasses  */
public class Team<T extends Player> {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    /* ArrayList of T type, which can accept many different forms of inputs.  */
    private ArrayList<T> members = new ArrayList<>();


    public Team(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    /* player is now a T type input, which means I could take argument from Baseball type, Football type, or Soccer
    * type players.  */
    public boolean addPlayer(T player) {
        /* If the ArrayList members contains the player, don't add.  */
        if (members.contains(player)) {
            System.out.println(player.getName() + " is already on this team.  ");
            return false;
        }
        /* Otherwise, add player to members.  */
        else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + name);
            return true;
        }
    }


    public int numPlayers() {
        return members.size();
    }


    /* Decide whether the match is won, lost, or tied.  */
    public void matchResult(Team opponent, int ourScore, int theirScore) {

        String message;

        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        }
        else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        }
        else {
            lost++;
            message = " lost to ";
        }
        played++;

        /* If there is an opponent, call this method again to set the opponent's record.  */
        if (opponent != null) {
            System.out.println(getName() + message + opponent.getName());
            /* Set opponent to null so the conditional statement will not execute again, which could cause an infinite
            * loop if it does.  Swap theirScore and ourScore to calculate the wins, losses, and ties for the opponent.  */
            opponent.matchResult(null, theirScore, ourScore);
        }
    }


    /* Winning a match grants 2 points, tying a match grants 1 point.  */
    public int ranking() {
        return (won * 2) + tied;
    }

}
