package s10p140_Generics_Challenge;

import java.util.ArrayList;
import java.util.Collections;

/* T extends upper bound to Team, T only accepts Team type objects or object types of Team's subclasses.  */
public class League<T extends Team> {

    public String name;
    /* An array list of similar objects, which can be any objects.  However, a league can only contain a list of
    * a single type objects, such as a list full of FootballPlayer objects.  */
    private ArrayList<T> league = new ArrayList<>();


    public League(String name) {
        this.name = name;
    }


    /* Add new teams to league.  */
    public boolean add(T team) {
        if(league.contains(team)) {
            return false;
        }
        else {
            league.add(team);
            return true;
        }
    }


    public void showLeagueTable() {
        /* Sort the ArrayList in order using compareTo() method from Team class.  */
        Collections.sort(league);
        /* Print out the sorted ArrayList.  */
        for(T t : league) {
            System.out.println(t.getName() + ":  " + t.ranking());
        }
    }

}
