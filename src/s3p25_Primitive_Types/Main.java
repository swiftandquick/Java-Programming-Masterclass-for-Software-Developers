package s3p25_Primitive_Types;

public class Main {

    public static void main(String[] args) {
        int myValue = 10000;

        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Integer Minimum Value:  " + myMinIntValue);
        System.out.println("Integer Maximum Value:  " + myMaxIntValue);

        /* Exceed maximum limit, causes an overflow. */
        System.out.println("Busted Maximum Value:  " + (myMaxIntValue + 1));

        /* Exceed minimum limit, causes an underflow.  */
        System.out.println("Busted Minimum Value:  " + (myMinIntValue - 1));

        /* Uncomment the code below and I will get an error because it exceed int's maximum limit.  */
        // int myMaxIntTest = 2147483648;

        /* I can use underscore to declare large numbers.  */
        int myMaxIntTest = 2_147_483_647;

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Maximum Value =  " + myMaxByteValue);
        System.out.println("Byte Minimum Value =  " + myMinByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Maximum Value =  " + myMaxShortValue);
        System.out.println("Short Minimum Value =  " + myMinShortValue);

        long myLongValue = 100L;
        
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Maximum Value =  " + myMaxLongValue);
        System.out.println("Long Minimum Value =  " + myMinLongValue);

        /* Put L at the end to indicate that it's a long value.  */
        long bigLongLiteralValue = 2_147_483_647_234L;
        System.out.println(bigLongLiteralValue);

        int myTotal = (myMinIntValue / 2);

        /* Casted (myMinByteValue / 2) as byte value.  */
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        System.out.println(myNewByteValue);

        /* Casted as short value.  */
        short myNewShortValue = (short) (myMinShortValue / 2);
        System.out.println(myNewShortValue);

    }

}
