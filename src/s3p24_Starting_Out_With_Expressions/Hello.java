package s3p24_Starting_Out_With_Expressions;

public class Hello {

    public static void main(String[] args) {

       int myFirstNumber = (10 + 5) + (2 * 10); // 35
       int mySecondNumber = 12;
       int myThirdNumber = myFirstNumber * 2; // 70
       int myTotal = myFirstNumber + mySecondNumber + myThirdNumber; // 117
       System.out.println(myTotal);
       int myLastOne = 1000 - myTotal;
       System.out.println(myLastOne);

    }

}