package s8p104_Reverse_Array_Challenge_Try;

import java.util.Arrays;

public class Main {

    private static void reverse(int[] array) {
        if (array.length == 1 || array.length == 0) {
            // do nothing;
        }
        else {
            /* Switch first and last index, switch second and second to last index, and so on.  */
            for(int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Array = " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed Array = " + Arrays.toString(array));
    }

}
