package s3p28_Primitive_Type_Challenge_Answer;

public class Main {

    public static void main(String[] args) {
        /* Primitive type challenge.  */
        byte myByte = 10;
        short myShort = 20;
        int myInt = 50;

        long longTotal = 50000L + 10L * (myByte + myShort + myInt);
        System.out.println(longTotal);

        short shortTotal = (short) (1000 + 10 * (myByte + myShort + myInt));
        System.out.println(shortTotal);
    }

}
