package s5p68_The_While_and_Do_While_Statements_b;

public class Main {

    public static boolean isEvenNumber(int number) {
        if (number % 2 == 0) {
            return true;
        }
        else {
            return false;
        }
    }


    public static void main(String[] args) {
        int number = 4;
        int finishNumber = 20;
        int evenNumbersFound = 0;

        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                /* If isEvenNumber returns false, skips to next iteration.  */
                continue;
            }

            System.out.println("Even number " + number);
            evenNumbersFound++;
            // If there are 5 or more total even numbers found, break out of the loop.
            if (evenNumbersFound >= 5) {
                break;
            }
        }
        System.out.println("Total even numbers found = " + evenNumbersFound);
    }

}
