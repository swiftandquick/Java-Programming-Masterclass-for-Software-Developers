package s12p172_Sorted_Collections;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityStock = 0;  // Can be initialized later.


    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantityStock = 0; // Or I can initialize here here, but I wouldn't normally do both.
    }


    /* Overloaded constructor with the ability to set all fields with parameter variables.  */
    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public int quantityInStock() {
        return quantityStock;
    }


    /* Only set price if argument is a positive number.   */
    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }


    /* Add number of items to the quantityStock value.  */
    public void adjustStock(int quantity) {
        int newQuantity = quantityStock + quantity;
        if(newQuantity >= 0) {
            quantityStock = newQuantity;
        }
    }


    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals().  ");
        /* If two objects are exactly the same.  */
        if(obj == this) {
            return true;
        }
        /* If obj is null or obj's class is different from current object's class.  */
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        /* Compare the name of this object and obj, if their names are equal, return true.  */
        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }


    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }


    /* Override compareTo() to change how objects should be sorted inside a collection.  */
    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo().  ");
        /* If two objects are exactly the same, return 0.  */
        if(this == o) {
            return 0;
        }
        /* Otherwise, return a number based on name comparison.  Return a positive number if this object's name
        * is alphabetically after o's name.  Return a negative number if this object's name is alphabetically before
        * o's name.  If both names are the same, return 0.  */
        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        /* We won't get here, but throw an exception just in case.  */
        throw new NullPointerException();
    }


    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }

}
