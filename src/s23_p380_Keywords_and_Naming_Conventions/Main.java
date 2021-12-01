package s23_p380_Keywords_and_Naming_Conventions;

public class Main {

    public static void main(String[] args) {
        double int2 = 50.00d;

        double milesDriven = 1000; // salesRepMileDriven or repMilesDriven.
        int customers = 50; // dailyCustomers or storeDailyCustomers.
        char lastKey = 'd'; // lastKeyPressed or playerLastKeyPressed.

        double kilometers = (100d * 1.603944d);

        int finalScore = 50;

        int playersHighScore;

        /* finalScore is originally 50, set it to 60, then store it in calculatedScore.  */
        int calculatedScore = finalScore = 60;
        System.out.println("Calculated Score = " + calculatedScore);

        int playerLives = 3;

        /* Prints 3, because the decrement happens after the expression (print statement) is evaluated.  */
        System.out.println("Lives remaining = " + playerLives--);

        /* Prints 2, because after the previous print statement is evaluated, playerLives is decreased to 2.  */
        System.out.println("Lives is now = " + playerLives);

        /* Prints 1, because the decrement happens before the expression (print statement) is evaluated.  */
        System.out.println("And subtracting 1 from lives = " + --playerLives);

        System.out.println("Lives remaining = " + playerLives++); // Prints 1.
        System.out.println("Lives is now = " + playerLives); // Prints 2.
        System.out.println("And adding 1 to lives = " + ++playerLives); // Prints 3.

        playerLives++;
        System.out.println("Lives remaining = " + playerLives); // Prints 4.
        playerLives--;
        System.out.println("Lives remaining = " + playerLives); // Prints 3.
        ++playerLives;
        System.out.println("Lives remaining = " + playerLives); // Prints 4.
        --playerLives;
        System.out.println("Lives remaining = " + playerLives); // Prints 3.

        if (calculatedScore > 59) {
            System.out.println("I calculate your score as being more than 59!  ");
        }

    }

}
