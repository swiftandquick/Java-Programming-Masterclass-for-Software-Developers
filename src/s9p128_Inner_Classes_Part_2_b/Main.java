package s9p128_Inner_Classes_Part_2_b;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    /* Call the Button constructor and pass in "Print" as argument.  */
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {

        /* Class ClickListener implements interface OnClickListener, which is from Button class.  */
        class ClickListener implements Button.OnClickListener {
            /* Empty constructor.  */
            public ClickListener() {
                System.out.println("I've been attached.  ");
            }

            /* Override the onClick method from Button class, get title as argument, which is "Print", then
            * print out title and extra text:  "Print was click.  "  */
            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked.  ");
            }
        }

        /* btnPrint invokes the setOnClickListener(), pass ClickListener (inner class object) as argument.  */
        btnPrint.setOnClickListener(new ClickListener());

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
