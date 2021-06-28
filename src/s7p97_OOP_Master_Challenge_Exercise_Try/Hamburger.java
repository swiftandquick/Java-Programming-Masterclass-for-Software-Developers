package s7p97_OOP_Master_Challenge_Exercise_Try;

public class Hamburger {

    private String name;
    private String meat;
    private double price;
    private String breadRollType;


    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
        System.out.println(name + " hamburger on a " + breadRollType + " with " + meat + ", price is " + price);
    }


    public void addHamburgerAddition(String additionName, double additionPrice) {
        System.out.println("Added " + additionName + " for an extra " + additionPrice);
        price = price + additionPrice;
    }


    public double itemizeHamburger() {
        return price;
    }

}
