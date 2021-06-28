package s10p137_Our_Generics_Class_Part_3;

// import java.util.ArrayList;
// import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        /* Create a Team object, and use addPlayer() method to add joe, pat, and beckham to Team's members array.  */
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        // adelaideCrows.addPlayer(pat);
        // adelaideCrows.addPlayer(beckham);

        /* Call the numPlayers() method to get the number of players.  */
        System.out.println(adelaideCrows.numPlayers());

        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
        baseballTeam.addPlayer(pat);

        /* T (parameter) in addPlayer() method can take any Object as argument, since String is an object, so I can
        pass a String like "no-one" as argument.  */
        /* Since I set T's upper bound to Player, this is no longer true.  */
        /*
        Team<String> brokenTeam = new Team<>("This won't work.  ");
        brokenTeam.addPlayer("no-one");
        */

        Team<SoccerPlayer> brokenTeam = new Team<>("This won't work.  ");
        brokenTeam.addPlayer(beckham);

        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        FootballPlayer banks = new FootballPlayer("Gordon");
        melbourne.addPlayer(banks);

        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        /* Add 1 win for hawthorn, add 1 loss to fremantle.  */
        hawthorn.matchResult(fremantle, 1, 0);

        /* Add 1 loss to hawthorn, add 1 win to adelaideCrows.  */
        hawthorn.matchResult(adelaideCrows, 3, 8);

        /* Add 1 win to adelaideCrows, add 1 loss to fremantle.  */
        adelaideCrows.matchResult(fremantle, 2, 1);

        /* Add 1 tie to both adelaideCrows and baseballTeam.  */
        /* adelaideCrows is defined as FootballPlayer type, baseballTeam is defined as BaseballPlayer type.  */
        // adelaideCrows.matchResult(baseballTeam, 1, 1);

        /* Print out the number of points each team has.  */
        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ":  " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ":  " + melbourne.ranking());
        System.out.println(fremantle.getName() + ":  " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ":  " + hawthorn.ranking());

        System.out.println(adelaideCrows.compareTo(melbourne));
        System.out.println(adelaideCrows.compareTo(hawthorn));
        System.out.println(hawthorn.compareTo(adelaideCrows));
        System.out.println(melbourne.compareTo((fremantle)));

        // ArrayList<Team> teams;

        /* sort() method utilize the compareTo() method to sort the objects.  */
        // Collections.sort(teams);
    }

}
