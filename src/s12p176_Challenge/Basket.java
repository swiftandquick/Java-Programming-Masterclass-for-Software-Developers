package s12p176_Challenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;


    public Basket(String name) {
        this.name = name;
        list = new TreeMap<StockItem, Integer>();
    }


    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        else {
            return 0;
        }
    }


    public int removeFromBasket(StockItem item, int quantity) {
        if((item != null) && (quantity > 0)) {
            /* Check if we already have the item in the basket.  */
            int inBasket = list.getOrDefault(item, 0);
            /* If I do have the item, inBasket will not be the default value, which is 0, instead, so subtract the
            * quantity from the inBasket's current value.  */
            int newQuantity = inBasket - quantity;

            if(newQuantity > 0) {
                /* Replace the item's value with a new value.  */
                list.put(item, newQuantity);
                return quantity;
            }
            /* If newQuantity is 0, remove the item from the basket map.  */
            else if(newQuantity == 0) {
                list.remove(item);
                return quantity;
            }
        }
        /* If above conditions don't meet, return 0.  */
        return 0;
    }


    /* Clears the basket, if this method is called, all of the list's entries are removed.  */
    public void clearBasket() {
        list.clear();
    }


    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }


    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() +
                ((list.size() == 1) ? " item" : " items") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ".  " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }

}
