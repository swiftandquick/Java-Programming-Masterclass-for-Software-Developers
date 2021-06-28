package s8p99_Arrays;

import java.util.Scanner;

public class Main {

    /* Create a global variable scanner, use to input numbers.  */
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        /* Creates an array that holds 10 int type values.  */
        int[] myIntArray = new int[10];

        /* Assign the value to indices.  For example, assign sixth index (index 5) to have a value of 50.  */
        myIntArray[0] = 45;
        myIntArray[1] = 476;
        myIntArray[5] = 50;

        /* Print index 5 of myIntArray array.  */
        System.out.println(myIntArray[5]);

        /* Create an array and initialize the values of each index.  */
        int[] myIntArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(myIntArray2[0]);
        System.out.println(myIntArray2[6]);
        System.out.println(myIntArray2[9]);

        /* Use for loop to initialize each index of the array.  */
        int[] myIntArray3 = new int[25];
        for(int i = 0; i < myIntArray3.length; i++) {
            myIntArray3[i] = i * 10;
        }
        printArray(myIntArray3);

        /* Creates an array that holds 10 double type values.  */
        double[] myDoubleArray = new double[10];


        /* getIntegers method return an array with size of 5.  */
        int[] myIntegers = getIntegers(5);
        printArray(myIntegers);
        System.out.println("The average is " + getAverage(myIntegers));
    }


    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ", value is " + array[i]);
        }
    }


    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        /* Initialize each index of the arrays by entering the number in the console via scanner.  */
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }


    /* Get the average of the array.  */
    public static double getAverage(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / (double) array.length;
    }

}
