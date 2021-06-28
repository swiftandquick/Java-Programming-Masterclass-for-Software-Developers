package s10p140_Generics_Challenge;

public class Main {

    public static void main(String[] args) {

        /* Defines a League object that stores Team object that has FootballPlayer objects.  */
        League<Team<FootballPlayer>> footballLeague = new League<>("AFL");

        /* Create Team objects that contain FootballPlayer objects.  */
        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        /* Create a Team object that contains BaseballPlayer object.  */
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");

        /* Add teams to the league ArrayList.  */
        footballLeague.add(adelaideCrows);
        footballLeague.add(melbourne);
        footballLeague.add(hawthorn);
        footballLeague.add(fremantle);

        /* footballLeague only accept Team the contain objects of FootballPlayer.   */
        // footballLeague.add(baseballTeam);

        /* Add 1 win for hawthorn, add 1 loss to fremantle.  */
        hawthorn.matchResult(fremantle, 1, 0);

        /* Add 1 loss to hawthorn, add 1 win to adelaideCrows.  */
        hawthorn.matchResult(adelaideCrows, 3, 8);

        /* Add 1 win to adelaideCrows, add 1 loss to fremantle.  */
        adelaideCrows.matchResult(fremantle, 2, 1);

        /* Print out the ranking in order based on points for all teams.  */
        footballLeague.showLeagueTable();

        Team rawTeam = new Team("Raw Team");

        /* Create BaseballPlayer and SoccerPlayer objects.  */
        BaseballPlayer pat = new BaseballPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        rawTeam.addPlayer(beckham); // Unchecked warning.
        rawTeam.addPlayer(pat); // Unchecked warning.

        footballLeague.add(rawTeam); // Unchecked warning.

        League<Team> rawLeague = new League<>("Raw");
        rawLeague.add(adelaideCrows); // No warning.
        rawLeague.add(baseballTeam); // No warning.
        rawLeague.add(rawTeam); // No warning.

        League reallyRaw = new League("Really Raw");
        reallyRaw.add(adelaideCrows); // Unchecked warning.
        reallyRaw.add(baseballTeam); // Unchecked warning.
        reallyRaw.add(rawTeam); // Unchecked warning.

    }

}
