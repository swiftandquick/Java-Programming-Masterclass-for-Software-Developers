package s8ce41_SortedArray;

import java.util.Scanner;

public class SortedArray {

    private static Scanner scanner = new Scanner(System.in);


    public static int[] getIntegers(int size) {
        int[] array = new int[size];
        System.out.println("Enter " + size + " integer values:\r");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }


    public static int[] sortIntegers(int[] array) {
        boolean flag = true;
        int temp;

        while(flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
        }

        return array;
    }


    public static void main(String[] args) {
        int[] myIntegers = getIntegers(6);
        int[] sorted = sortIntegers(myIntegers);
        printArray(sorted);
    }

}
