package s8p112_Autoboxing_and_Unboxing;

import java.util.ArrayList;

/* Wrapper class.  */
class IntClass {

    private int myValue;


    public IntClass(int myValue) {
        this.myValue = myValue;
    }


    public int getMyValue() {
        return myValue;
    }


    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }

}



public class Main {

    public static void main(String[] args) {
        String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Tim");

        /* Custom wrapper class for int type variables, wrap int as objects so I can put them in ArrayList.  */
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));

        /* Integer is a wrapper class for int type values.  */
        Integer integer = new Integer(54);

        /* Double is a wrapper class for double type values.  */
        Double doubleValue = new Double(12.25);

        ArrayList<Integer> intArrayList = new ArrayList<Integer>();

        /* Add integers 0 to 10 to ArrayList.
        * Autoboxing:  Convert primitive type to objects using wrapper class.  */
        for(int i = 0; i <= 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        /* Print out all variables from the ArrayList.
        * Unboxing:  Retrieve objects from wrapper class, then convert it back to primitive type.  */
        for(int i = 0; i <= 10; i++) {
            /* get():  Retrieves the object of specified index from the ArrayList.
            * intValue():  A method in Integer class, returns the integer representation of the specified object.  */
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
        }

        Integer myIntValue = 56; // Autoboxing

        /* In compile time, the code above turn into the code below, which is why I can set value of the Integer
        * class like I did.  */
        // Integer myIntValue = Integer.valueOf(56);

        int myInt = myIntValue; // Unboxing

        /* In compile time, the code above turn into the code below, which is why I can transform an object (Integer)
        into  a primitve type (int). */
        // int myInt = myIntValue.intValue();

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();

        // Autoboxing.
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(Double.valueOf(dbl));
        }

        // Unboxing.
        for (int i = 0; i < myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i + " --> " + value);
        }

    }

}
