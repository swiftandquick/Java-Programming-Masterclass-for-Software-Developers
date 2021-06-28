package s7ce38_Encapsulation;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;


    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        else {
            this.tonerLevel = -1;
        }
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }


    public int getPagesPrinted() {
        return pagesPrinted;
    }


    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (tonerLevel + tonerAmount > 100) {
                return -1;
            }
            else {
                tonerLevel = tonerLevel + tonerAmount;
                return tonerLevel;
            }
        }
        else {
            return -1;
        }
    }


    public int printPages(int pagesToPrint) {
        if (duplex) {
            System.out.println("Printing in duplex mode");
            int newPages = pagesToPrint / 2 + pagesToPrint % 2;
            pagesPrinted = pagesPrinted + newPages;
            return newPages;
        }
        else {
            pagesPrinted = pagesPrinted + pagesToPrint;
            return pagesToPrint;
        }
    }

}