package s6p86_Static_VS_Instance_Methods;

class Calculator {

    public static void printSum(int a, int b) {
        System.out.println("sum = " + (a + b));
    }

}


class Main {

    public static void main(String[] args) {
        /* Calls printSum(), a static method, from Calculator class.  */
        Calculator.printSum(5, 10);
        printHello(); // shorter form of Main.printHello();
    }

    public static void printHello() {
        System.out.println("Hello");
    }

}