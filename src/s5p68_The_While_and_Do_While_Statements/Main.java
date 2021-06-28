package s5p68_The_While_and_Do_While_Statements;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while(count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        /* Similar for loop.  */
        for (int i = 6; i != 6; i++) {
            System.out.println("Count value is " + count);
        }

        count = 1;
        while (true) {
            if (count == 6) {
                /* Breaks out of the infinite loop if count is 6.  */
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

        /* count starts as 6, count became 7 after first iteration, so
        * the count != 6 condition is never false, therefore I need to
        * use the break statement to get out of the loop when count > 100.  */
        count = 6;
        do {
            System.out.println("Count value was " + count);
            count++;

            if (count > 100) {
                break;
            }
        } while (count != 6);
    }

}
