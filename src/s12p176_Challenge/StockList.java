package s12p176_Challenge;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;


    public StockList() {
        this.list = new LinkedHashMap<String, StockItem>();
    }


    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.get(item.getName());
            if(inStock != null) {
                item.adjustStock(inStock.availableQuantity());
            }
            list.put(item.getName(), item);
            return item.availableQuantity();
        }
        else {
            return 0;
        }
    }


    public int sellStock(String item, int quantity) {
        StockItem inStock = list.get(item);

        if((inStock != null) && (quantity > 0)) {
            /* Call finaliseStock() method to sell items.  */
            return inStock.finaliseStock(quantity);
        }
        else {
            return 0;
        }
        /*
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.availableQuantity() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        else {
            return 0;
        }
         */
    }


    public int reserveStock(String item, int quantity) {
        /* Retrieve the value (StockItem) if item, if the key is equal to item, then I will retrieve a non-null value.  */
        StockItem inStock = list.get(item);

        /* If inStock is not null and if quantity is greater than 0.  */
        if((inStock != null) && (quantity > 0)) {
            /* Call the reserveStock() method in StockItem class, it can return 0 or return a positive number, it will
            only return a positive number if quantity is less than available stock.  */
            return inStock.reserveStock(quantity);
        }
        else {
            return 0;
        }
    }


    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.get(item);
        if((inStock != null) && (quantity > 0)) {
            /* Returns a positive number if quantity is less than the current value of reserved.  */
            return inStock.unreserveStock(quantity);
        }
        else {
            return 0;
        }
    }


    public StockItem get(String key) {
        return list.get(key);
    }


    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<String, Double>();
        for(Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }


    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }


    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.availableQuantity();
            s = s + stockItem + ".  There are " + stockItem.availableQuantity() + " in stock.  Value of items:  " +
                    String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }

}
