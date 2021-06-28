package s7p94_Challenge_Exercise_Try;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(50, true);

        System.out.println("Duplex:  " + printer.isDuplex());

        System.out.println("Toner Level:  " + printer.getTonerLevel());

        /* Toner level stays the same my argument is a negative number.  */
        printer.fillUpToner(-5);
        System.out.println("Toner Level:  " + printer.getTonerLevel());

        /* Toner level increase by 25%, 50% -> 75%.  */
        printer.fillUpToner(25);
        System.out.println("Toner Level:  " + printer.getTonerLevel());

        /* Toner level increase by 50%, 75% -> 125%, since 125% exceeds 100%, toner level is adjust to 100%.  */
        printer.fillUpToner(50);
        System.out.println("Toner Level:  " + printer.getTonerLevel());

        /* Initial value of printedPages is 0.  */
        System.out.println("Printed Pages:  " + printer.getPrintedPages());

        /* Printed pages stay the same because argument is negative.  */
        printer.printPages(-5);
        System.out.println("Printed Pages:  " + printer.getPrintedPages());

        /* printedPages increase by 15.  */
        printer.printPages(15);
        System.out.println("Printed Pages:  " + printer.getPrintedPages());
        
    }

}
