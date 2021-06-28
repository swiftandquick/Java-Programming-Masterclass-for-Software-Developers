package s11p150_The_Static_Statement;

public class Main {

    public static int multiplier = 7;


    public static int multiply(int number) {
        return number * multiplier;
    }


    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st Instance");
        /* Use class name StaticTest to invoke static method getNumInstances.  */
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        /* Because numInstances is a static variable, it is increment from 1 to 2 when constructor is called for the
        second time.  */
        StaticTest secondInstance = new StaticTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        /* Can't directly access to non-static variable and methods, so multiply() and multiplier have to be static.  */
        int answer = multiply(6);
        System.out.println("The answer is " + answer);
        System.out.println("Multiplier is " + multiplier);
    }

}
