package s12p175_TreeMap_and_Unmodfiable_Maps;

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
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        else {
            return 0;
        }
    }


    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
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
            /* getValue() returns StockItem type, use it to invoke getPrice() method to get the price.  */
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        /* Returns an only-read Map that's called prices.  */
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
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ".  There are " + stockItem.quantityInStock() + " in stock.  Value of items:  " +
                    String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }

}
