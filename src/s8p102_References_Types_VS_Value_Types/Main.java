package s8p102_References_Types_VS_Value_Types;

import java.util.Arrays;

public class Main {

    /* array = myIntArray.  */
    private static void modifyArray(int[] array) {
        array[0] = 2;

        /* Use new to create a new array in the memory, so I dereference the reference, which means array
        * no long share the same reference as anotherArray.  */
        array = new int[] {1, 2, 3, 4, 5};
    }


    public static void main(String[] args) {

        /* Value type.  */

        /* When I set myIntValue = 10, a single space in memory is allocated to store the value of that variable.  */
        int myIntValue = 10;

        /* When I assign anotherIntValue = myIntValue, the value is copied to anotherIntValue, but the memory that
        * anotherIntValue in is different from the memory that myIntValue in, so if one value change, the other
        * stay the same.  */
        int anotherIntValue = myIntValue;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        /* anotherIntValue increases, but myIntValue stays the same.  */
        anotherIntValue++;

        System.out.println("myIntValue = " + myIntValue);
        System.out.println("anotherIntValue = " + anotherIntValue);

        /* Reference type.  */

        /* myIntArray is a reference to the array in memory.  */
        int[] myIntArray = new int[5];

        /* Declare another reference to the same array in memory.  Both myIntArray and anotherArray hold the same address.  */
        int[] anotherArray = myIntArray;

        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        /* Since array is a reference type, both arrays refer to the same array in memory.  When an array element of one
        array changes, elements of both arrays also change, both anotherArray[0] and myIntArray[0] will have 1 as the value.  */
        anotherArray[0] = 1;
        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));

        /* Use new keyword to create a new array in the memory for anotherArray, so I dereference anotherArray from
        * the reference, which means anotherArray is now point to a different array in memory.  Both arrays are now different.  */
        anotherArray = new int[] {4, 5, 6, 7, 8};
        modifyArray(myIntArray);
        System.out.println("after modify myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after modify anotherArray = " + Arrays.toString(anotherArray));

    }

}
