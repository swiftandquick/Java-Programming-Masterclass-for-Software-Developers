package s11p148_Scope_Challenge_Exercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number:  ");
        /* The number I enter is the instance variable x's value.  */
        X x = new X(scanner.nextInt());
        /* Call the x() method from X class.  */
        x.x();

        scanner.close();

    }

}
