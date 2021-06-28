package s7p97_OOP_Master_Challenge_Exercise_Try;

public class HealthyBurger extends Hamburger {


    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, price, "Brown rye roll");
    }


    @Override
    public void addHamburgerAddition(String additionName, double additionPrice) {
        super.addHamburgerAddition(additionName, additionPrice);
    }


    public void addHealthyAddition(String healthyExtraName, double healthyExtraPrice) {
        super.addHamburgerAddition(healthyExtraName, healthyExtraPrice);
    }


    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }

}
