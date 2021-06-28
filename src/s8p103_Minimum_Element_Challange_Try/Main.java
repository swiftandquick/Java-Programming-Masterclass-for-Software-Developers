package s8p103_Minimum_Element_Challange_Try;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static int readInteger() {
        System.out.println("How many elements do you need to enter?  ");
        return scanner.nextInt();
    }


    public static int[] readElements(int elements) {
        System.out.println("Enter " + elements + " numbers.  ");
        int[] array = new int[elements];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }


    public static int findMin(int[] array) {
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
