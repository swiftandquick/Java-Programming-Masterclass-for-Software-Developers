package s7p94_Challenge_Exercise_Answer;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;


    public Printer(int tonerLevel, boolean duplex) {
        /* tonerLevel is between 0 and 100, if it is not, set tonerLevel to -1, which represent error.  */
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        else {
            this.tonerLevel = -1;
        }
        this.pagesPrinted = pagesPrinted;
        this.duplex = duplex;
    }


    public int getTonerLevel() {
        return tonerLevel;
    }


    public int getPagesPrinted() {
        return pagesPrinted;
    }


    public boolean isDuplex() {
        return duplex;
    }


    public int addToner(int tonerAmount) {
        /* If tonerLevel is between 0 and 100.  */
        if (tonerLevel > 0 && tonerAmount <= 100) {
            // If tonerLevel + tonerAmount exceed 100, return -1, representing error.
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            }
            // Return new toner level which is tonerLevel + tonerAmount.
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        }
        else {
            return -1;
        }
    }


    public int printPages(int pages) {
        int pagesToPrint = pages;
        /* If printer is duplex, which means it can print two sides, the numbers of papers that will be used to print
        * the pages is halved.  */
        if (this.duplex) {
            pagesToPrint = pages / 2 + pages % 2;
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }

}
