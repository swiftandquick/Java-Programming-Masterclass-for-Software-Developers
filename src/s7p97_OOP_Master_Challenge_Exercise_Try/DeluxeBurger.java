package s7p97_OOP_Master_Challenge_Exercise_Try;

public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White roll");
        super.addHamburgerAddition("Chips", 2.75);
        super.addHamburgerAddition("Drink", 1.81);
    }


    /* Can't add additional items to Deluxe burger.  */
    @Override
    public void addHamburgerAddition(String additionName, double additionPrice) {
        // Do nothing.
    }


    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }
}
