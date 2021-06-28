package s7p92_Composition_Part_2_Challenge_Exercise;

public class PC {

    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    /* The PC has a case, has a monitor, and has a motherboard.  The PC class is comprise of three other classes.  */
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        /* Use theCase (instance of Case) to call pressPowerButton() method.  */
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        /* Use monitor (instance of Monitor) to call drawPixelAt() method.  */
        monitor.drawPixelAt(1200, 50, "yellow");
    }

}
