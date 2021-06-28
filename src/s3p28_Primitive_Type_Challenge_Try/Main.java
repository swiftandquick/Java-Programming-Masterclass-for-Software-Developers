package s3p28_Primitive_Type_Challenge_Try;

public class Main {

    public static void main(String[] args) {

        byte myByte = 50;
        short myShort = 500;
        int myInt = 50000;

        long myLong = 50000 + (myByte + myShort + myInt) * 10;

        System.out.println(myLong);

    }

}
