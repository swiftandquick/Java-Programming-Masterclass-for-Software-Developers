package s12p172_Sorted_Collections;

public class Main {

    private static StockList stockList = new StockList();


    public static void main(String[] args) {

        /* Create a StockItem.  */
        StockItem temp = new StockItem("bread", 0.86, 100);
        /* Use stockList to invoke addStock(), which adds the temp item to the list Map in StockList class.  */
        stockList.addStock(temp);

        /* Use variable temp to create a new StockItem object.  */
        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
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

        /* Use stockList to invoke Items() method to return a read-only list (Map), then iterate through each key of
        * the list (Map).  Because I declare list as LinkedHashMap, the order of items printed is the same as the
        * order of insertion.  */
        for(String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

    }

}
