package s11p142_Packages;

public class Main {

    public static void main(String[] args) {
        /* Use a variable from another package.  */
        // org.w3c.dom.Node node = null;

        MyWindow myWindow = new MyWindow("Complete Java");
        myWindow.setVisible(true);
    }

}
