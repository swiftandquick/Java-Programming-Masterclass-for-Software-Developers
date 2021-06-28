package s9p128_Inner_Classes_Part_2_c;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /* Call the Button constructor and pass in "Print" as argument.  */
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        /* Anonymous inner class.  Use Button type object btnPrint to invoke the setOnClickListener() method, then
        * takes in an anonymous object Button.OnClickListener() as argument.  */
        btnPrint.setOnClickListener(new Button.OnClickListener() {
            /* Overrides the onCllick method from Button class, takes title ("Print") as argument, and prints out
            * the title along with extra text:  "Print was clicked  ."  */
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.");
            }
        });

        /* Call the listen method.  */
        listen();
    }


    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 0:
                    quit = true;
                    break;
                /* Use Button type object btnPrint to access the onClick method.  */
                case 1:
                    btnPrint.onClick();

            }
        }
    }
}
