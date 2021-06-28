package s10p136_Generics_Introduction;

import java.util.ArrayList;

public class Main {

    private static void printDoubled(ArrayList<Integer> n) {
        /* Iterate through every object.  */
        for(Object i : n) {
            /* Cast Object as Integer.  */
            System.out.println((Integer) i * 2);
        }
    }


    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<Integer>();
        items.add(1);
        items.add(2);
        items.add(3);
        // items.add("tim");
        items.add(4);
        items.add(5);

        printDoubled(items);
    }

}
