package s10p137_Our_Generics_Class;

import java.util.ArrayList;

public class Team {

    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private ArrayList<Player> members = new ArrayList<>();


    public Team(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public boolean addPlayer(Player player) {
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
        if (ourScore > theirScore) {
            won++;
        }
        else if (ourScore == theirScore) {
            tied++;
        }
        else {
            lost++;
        }
        played++;

        /* If there is an opponent, call this method again to set the opponent's record.  */
        if (opponent != null) {
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
