package s12p176_Challenge;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();


    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item + ".  ");
            return 0;
        }
        /* Call the reserveStock method, if returned value is not 0, add stockItem to basket.  */
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }


    /* Similar to sellItem, but this method remove items from the basket.  */
    public static int removeItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item + ".  ");
            return 0;
        }
        /* Use basket to call the removeFromBasket() method, if it returns a number equal to quantity.  If items
        * are remove from the basket, it goes back to the stock, so unreserveStock() method is called.  */
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }


    /* When check out, call the use stockList to sellStock(), then sell the stock that are in the basket.  */
    public static void checkOut(Basket basket) {
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
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
        /* Since I put 1 car in timsBasket, 1 car is also put to reserve until it's purchased.  */
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        if(sellItem(timsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock.  ");
        }
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        sellItem(timsBasket, "bread", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        /* Remove items from the basket and put items back to the stock.  */
        removeItem(timsBasket, "car", 1);
        removeItem(timsBasket, "cup", 9);
        removeItem(timsBasket, "car", 1);
        /* timsBasket only has 2 cars, so calling removeItem will return 0 this time.  */
        System.out.println("Cars removed:  " + removeItem(timsBasket, "car", 1));

        System.out.println(timsBasket);

        /* Remove all items from timsBasket.  */
        removeItem(timsBasket, "bread", 1);
        removeItem(timsBasket, "cup", 3);
        removeItem(timsBasket, "juice", 4);
        removeItem(timsBasket, "cup", 3);

        System.out.println(timsBasket);

        System.out.println("\nDisplay stock list before and after checkout.  ");
        System.out.println(basket);
        System.out.println(stockList);
        /* Sell the items in basket.  */
        checkOut(basket);
        System.out.println(basket);
        /* stockList has items removed.  */
        System.out.println(stockList);

        /* I can call the adjustStock() in 2 different ways.  */
        StockItem car = stockList.Items().get("car");
        if(car != null) {
            car.adjustStock(2000);
        }
        if(car != null) {
            stockList.get("car").adjustStock(-1000);
        }
        System.out.println(stockList);

        /*
        for(Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
         */

        checkOut(timsBasket);
        System.out.println(timsBasket);

        /* Commit test.  */
    }

}
