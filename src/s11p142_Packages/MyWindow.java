package s11p142_Packages;

/* Import all classes from the java.awt package.  */
import java.awt.*;

/* Import all classes from the java.awt.event package.  */
import java.awt.event.*;

public class MyWindow extends Frame {

    public MyWindow(String title) {
        super(title);
        setSize(500, 140);
        /* If I click on the close button (X button), I will close the app.  */
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);

        /* Draw String at 60 pixels to the right and 60 pixels downward.  */
        g.drawString("The Complete Java Developer Course", 60, 60);

        g.setFont(sansSerifSmall);
        g.drawString("by Tim Buchalka", 60, 100);
    }

}
