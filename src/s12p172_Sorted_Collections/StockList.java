package s12p172_Sorted_Collections;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;


    /* Instantiate an empty map.  */
    public StockList() {
        /* LinkedHashMap is similar to HashMap, except the order of entries are the same as insertion order.  */
        this.list = new LinkedHashMap<String, StockItem>();
    }


    public int addStock(StockItem item) {
        if (item != null) {
            /* Try to retrieve the item with the name as key.  Check if there is already quantities of this item.  */
            StockItem inStock = list.get(item.getName());
            /* If the item with the name exists, it will not return null.  */
            if(inStock != null) {
                /* The item with the name already exists, call adjustStock() to add inStock's quantityStock value
                * to item's current quantityStock value.  If there are already stocks of this item, adjust the quantity.  */
                item.adjustStock(inStock.quantityInStock());
            }
            /* Put the item in the list Map.  */
            list.put(item.getName(), item);
            /* Return the quantityStock value of item.  */
            return item.quantityInStock();
        }
        /* Return 0 only if the item is null.  */
        else {
            return 0;
        }
    }


    public int sellStock(String item, int quantity) {
        /* item is String here instead of StockItem, so if the item exists in the list, retrieve the item,
        * otherwise, set inStock as the default value, which is null.  */
        StockItem inStock = list.getOrDefault(item, null);

        /* If inStock is not null, which means inStock is able to retrieve a StockItem object with the name same as
        * item, inStock's quantityStock value must be greater than quantity (from parameter) because the amount that
        * items in stock must be less than the amount of items that I want to sell, and quantity (from parameter) is
        * greater than 0.  */
        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            /* Subtract the total quantity by the amount of quantity that I want to sell.  For example, if
            quantityStock is 5, and quantity (from paramter) is 2, after calling sellStock() method, the new
             quantityStock value will be 3.  */
            inStock.adjustStock(-quantity);
            return quantity;
        }
        /* Return 0 if inStock is null, which means I can't locate the item.  */
        else {
            return 0;
        }
    }


    /* Return the StockItem (value) base on the String key's (key) value.  */
    public StockItem get(String key) {
        return list.get(key);
    }


    /* Makes the Map list not modifiable and read-only, which means I can't use methods like put() to add items
    * to the list.  */
    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }


    /* Return StockList in String format.  */
    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ".  There are " + stockItem.quantityInStock() + " in stock.  Value of items:  " +
                    String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }

}
