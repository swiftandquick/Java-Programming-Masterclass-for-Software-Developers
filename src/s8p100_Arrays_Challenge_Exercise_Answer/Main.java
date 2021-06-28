package s8p100_Arrays_Challenge_Exercise_Answer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    /* Enter 5 numbers to fill the array indices.  */
    public static int[] getIntegers(int capacity) {
        int[] array = new int[capacity];
        System.out.println("Enter " + capacity + " integer values:\r");
        for(int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }


    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }


    public static int[] sortIntegers(int[] array) {

        /* sortedArray is initially identical as array.  */
        int[] sortedArray = Arrays.copyOf(array, array.length);

        /* Set flag to true to execute the while loop at least once.  */
        boolean flag = true;
        int temp;

        /* {106, 26, 81, 5, 15}.  flag = true, executes while loop, set flag = false.
        {106, 26, 81, 5, 15}.  108 < 26, false, for loop iterates again.
        {106, 26, 81, 5, 15}.  26 < 81, true, swap 26 and 81, flag = true, for loop iterates again.
        {106, 81, 26, 5, 15}.  26 < 5, false, for loop iterates again.
        {106, 81, 26, 5, 15}.  5 < 15, true, swap 5 and 15, flag = true, for loop exits because second to last index is checked.
        {106, 81, 26, 15, 5}.  flag = true, while loop iterates again, set flag = false.
        {106, 81, 26, 15, 5}.  108 < 81, false, for loop iterates again.
        {106, 81, 26, 15, 5}.  81 < 26, false, for loop iterates again.
        {106, 81, 26, 15, 5}.  26 < 15, false, for loop iterates again.
        {106, 81, 26, 15, 5}.  15 < 5, false, for loop iterates again, for loop exits because second to last index is checked.
        Since codes inside conditional statement is never executed during the second iteration of the while loop,
        flag remains false, while loop exits with sortedArray being {106, 81, 26, 15, 5}.  */
        while (flag) {
            /* While loop will only continue if the flag is assigned true later on.  */
            flag = false;
            /* Loop checks from first element to second to last element.  */
            for (int i = 0; i < sortedArray.length - 1; i++) {
                /* If element of current index is less than element of next index, switch the two elements' index position.
                * For example, sortedArray[1] = 26, sortedArray[2] = 81, 26 < 81, the condition is true.  This means
                * the new sortedArray[1] value is 81, while the new sortedArray[2] value is 26.  */
                /* If sortedArray[i] < sortedArray[i + 1] isn't true for all indices, then the codes inside the conditional
                statement will not execute, thus flag remains false, and the while loop will exit.  */
                if(sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i]; // Use temp to store the element of current index's value.
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    /* Set the flag to true indicates that the while loop will continue to run as long as the array
                    isn't properly sorted.  */
                    flag = true;
                }
            }
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

}
