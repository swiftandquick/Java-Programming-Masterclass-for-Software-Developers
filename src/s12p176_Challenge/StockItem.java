package s12p176_Challenge;

public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityInStock = 0;
    /* The variable is used to store the number of items reserved.  */
    private int reserved = 0;


    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        quantityInStock = 0;
    }


    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityStock;
    }


    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }


    public int availableQuantity() {
        /* The number of items in stock doesn't include the reserved items.  */
        return quantityInStock - reserved;
    }


    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }


    public void adjustStock(int quantity) {
        int newQuantity = quantityInStock + quantity;
        if(newQuantity >= 0) {
            quantityInStock = newQuantity;
        }
    }


    public int reserveStock(int quantity) {
        /* Only reserve stock when the amount I want to reserve is less than or equal to the amount of items I have
        * in stock.  Use the method (availableQuantity()), not the field (quantityInStock).  */
        if(quantity <= availableQuantity()) {
            reserved += quantity;
            return quantity;
        }
        else {
            return 0;
        }
    }


    public int unreserveStock(int quantity) {
        /* Only unreserve the stock if the quantity is less than or equal to reserved, because I can't unreserve
        * more items than what I previously reserved.  */
        if(quantity <= reserved) {
            reserved -= quantity;
            return quantity;
        }
        else {
            return 0;
        }
    }


    /* This method finalizes the transaction of stock, in other words, sell the stock.  */
    public int finaliseStock(int quantity) {
        /* If quantity is less than or equal to reserved, which in turn should also be  less than or equal to the
        returned value of availableQuantity().  */
        if (quantity <= reserved) {
            /* Subtract quantity from both quantityInStock and reserved.  */
            quantityInStock -= quantity;
            reserved -= quantity;
            return quantity;
        }
        else {
            return 0;
        }
    }


    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals().  ");
        if(obj == this) {
            return true;
        }
        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }


    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }


    @Override
    public int compareTo(StockItem o) {
        // System.out.println("Entering StockItem.compareTo().  ");
        if(this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }


    @Override
    public String toString() {
        return this.name + " : price " + this.price + ".  Reserved:  " + this.reserved;
    }

}
