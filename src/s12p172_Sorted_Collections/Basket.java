package s12p172_Sorted_Collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Basket {

    private final String name;
    /* StockItem is the item type, Integer is the quantity of items.  */
    private final Map<StockItem, Integer> list;


    public Basket(String name) {
        this.name = name;
        list = new HashMap<StockItem, Integer>();
    }


    public int addToBasket(StockItem item, int quantity) {
        /* If item is not null and quantity is a positive number.  */
        if ((item != null) && (quantity > 0)) {
            /* If item (StockItem) exists in the list, retrieve its value (Integer).  If it doesn't, set inBasket
            * equals to 0, which is the default value.  */
            int inBasket = list.getOrDefault(item, 0);
            /* Put the entry in the Map list, with item as key and inBasket as value.  */
            list.put(item, inBasket);
            return inBasket; // Return the quantity of items to be added.
        }
        else {
            return 0; // Return 0.
        }
    }


    public Map<StockItem, Integer> Items() {
        /* Makes list read-only.  */
        return Collections.unmodifiableMap(list);
    }


    /* Return Basket in String format.  */
    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ".  " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }

}
