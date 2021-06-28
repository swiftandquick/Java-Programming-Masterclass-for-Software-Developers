package s8p105_List_and_ArrayList_Part_1;

import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static int[] baseData = new int[10];


    /* Set the elements for the array baseData.  */
    private static void getInput() {
        for (int i = 0; i < baseData.length; i++) {
            baseData[i] = s.nextInt();
        }
    }


    /* Print the array.  */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    private static void resizeArray() {
        /* Create an array original, which share the same array in the memory of baseData.  */
        int[] original = baseData;
        /* Dereferencing, create a new array of size 12 in the memory.  */
        baseData = new int[12];
        /* Copy the original array elements into the the new array (baseData).  */
        for (int i = 0; i < original.length; i++) {
            baseData[i] = original[i];
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter 10 integers:  ");
        getInput();
        printArray(baseData);
        resizeArray();
        System.out.println("Enter 12 integers:  ");
        getInput();
        /* I can also manually set the index 10 and index 11 elements.  */
        // baseData[10] = 67;
        // baseData[11] = 34;
        printArray(baseData);
    }

}
