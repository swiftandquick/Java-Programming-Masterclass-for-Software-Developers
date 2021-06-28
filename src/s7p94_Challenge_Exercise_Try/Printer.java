package s7p94_Challenge_Exercise_Try;

public class Printer {

    private int tonerLevel; // 0 - 100, represents toner level at 0% to 100%.
    private int printedPages;
    private boolean duplex; // Duplex printer can print on both sides of the paper.


    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel < 0) {
            this.tonerLevel = 0;
        }
        else if (tonerLevel > 100) {
            this.tonerLevel = 100;
        }
        else {
            this.tonerLevel = tonerLevel;
        }
        this.printedPages = 0;
        this.duplex = duplex;
    }


    public int getTonerLevel() {
        return tonerLevel;
    }


    public int getPrintedPages() {
        return printedPages;
    }


    public boolean isDuplex() {
        return duplex;
    }


    public void fillUpToner(int tonerInc) {
        if (tonerInc >= 0 && tonerLevel + tonerInc <= 100) {
            tonerLevel = tonerLevel + tonerInc;
        }
        else if (tonerInc < 0) {
            // Nothing.
        }
        else {
            tonerLevel = 100;
        }
    }


    public void printPages(int newPages) {
        if (newPages >= 0) {
            printedPages = printedPages + newPages;
        }
    }

}
