package s8ce42_Minimum_Element;

import java.util.Scanner;

public class MinimumElement {

    private static Scanner scanner = new Scanner(System.in);


    private static int readInteger() {
        System.out.println("How many elements do you need to enter?  ");
        int elements = scanner.nextInt();
        return elements;
    }


    private static int[] readElements(int elements) {
        System.out.println("Enter " + elements + " numbers.  ");
        int[] array = new int[elements];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }


    private static int findMin(int[] array) {
        System.out.println("Finding the minimum number...  ");
        /* Set min equal to highest possible integer value.  */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int elements = readInteger();
        int[] array = readElements(elements);
        System.out.println(findMin(array));
    }

}
