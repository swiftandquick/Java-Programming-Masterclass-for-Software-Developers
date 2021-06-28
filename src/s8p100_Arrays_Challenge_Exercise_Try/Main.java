package s8p100_Arrays_Challenge_Exercise_Try;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    /* Gets the length of the array.  */
    public static int getIntegers(int[] array) {
        return array.length;
    }


    /* Print out the array.  */
    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }


    public static int[] sortIntegers(int[] array) {
        /* The sort method does not work if array is primitive type, convert int[] to Integer[] via for loop.  */
        Integer[] array2 = new Integer[array.length];
        for(int i = 0; i < array.length; i++) {
            array2[i] = array[i];
        }

        /* Sort the Integer array in reverse order.  */
        Arrays.sort(array2, Collections.reverseOrder());

        /* Convert Integer array back to int array after sorting.  */
        int[] array3 = new int[array2.length];
        for(int i = 0; i < array2.length; i++) {
            array3[i] = array2[i];
        }
        return array3;
    }


    public static void main(String[] args) {

        int[] array = {106, 26, 81, 5, 15};

        /* Get the length of the array.  */
        System.out.println(getIntegers(array));

        /* Print array.  */
        printArray(array);

        /* Sort the array in descending order.  */
        array = sortIntegers(array);

        /* Print the array again.  */
        printArray(array);
    }

}
