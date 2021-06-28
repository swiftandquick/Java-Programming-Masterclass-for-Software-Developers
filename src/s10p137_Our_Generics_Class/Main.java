package s10p137_Our_Generics_Class;

public class Main {

    public static void main(String[] args) {
        FootballPlayer joe = new FootballPlayer("Joe");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        /* Create a Team object, and use addPlayer() method to add joe, pat, and beckham to Team's members array.  */
        Team adelaideCrows = new Team("Adelaide Crows");
        adelaideCrows.addPlayer(joe);
        adelaideCrows.addPlayer(pat);
        adelaideCrows.addPlayer(beckham);

        /* Call the numPlayers() method to get the number of players.  */
        System.out.println(adelaideCrows.numPlayers());

    }

}
