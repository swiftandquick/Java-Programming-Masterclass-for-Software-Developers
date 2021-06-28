package s12p175_TreeMap_and_Unmodfiable_Maps;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();


    public static int sellItem(Basket basket, String item, int quantity) {
        // Retrieve item from stockList.
        StockItem stockItem = stockList.get(item);
        /* If I can't retrieve the value of the entry with the key item (String), return 0.  */
        if(stockItem == null) {
            System.out.println("We don't sell " + item + ".  ");
            return 0;
        }
        /* Use stockList to invoke sellStock() method.  If the item is not null, and there are more items in stock
        * (inStock's quantityStock) is higher than quantity.  Add the entry to list in Basket class.  */
        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        /* Return 0 if the above conditions are not met.  */
        return 0;
    }


    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        /* Add another item with the name "cup".  The item's price value is updated to 0.45, while I add 7 quantityStock
        on top of 200, which means I have a total of 207 cups (quantityStock = 207).  */
        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
        /* Invoke sellItem() method to add "car" to basket.  */
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        /* Quantity of "car" increase to 2.  */
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        /* I can't buy any cars because there are only 2 cars, quantity of "car" remains 2.  The sellItem() method
        * will return 0.  */
        if(sellItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock.  ");
        }
        /* There is no such item as "spanner", so stockItem is null.  */
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        /* stockList has items' quantities deducted, because sellStock() is invoked every time sellItem() is invoked.  */
        System.out.println(stockList);

        /* Items() method returns an unmodifiable map, I can't modify it with methods like put().  */
        // temp = new StockItem("pen", 1.12);
        // stockList.Items().put(temp.getName(), temp);

        /* Here, I am not actually modifying the returned map from the Items() method, but rather, retrieve the
        * StockItem object (value) by using the get(String) method, with "car" being the key.  Then, I use the
        * returned StockItem object to invoke adjustStock() method by adding 2000 extra quantity for "car".  */
        stockList.Items().get("car").adjustStock(2000);
        /* Subtract quantityStock of "car" by 1000, now there are 1000 "car".  */
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

        /* Use stockList to invoke PriceList() to return a Map that contains the name (key) and price (value) of each
        entry, the returned Map from PriceList() cannot be modified.  */
        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

}
