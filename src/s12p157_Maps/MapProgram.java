package s12p157_Maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<String, String>();
        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map.  ");
        }
        else {
            /* Add a new item with key-value pair in the map, key is "Java", value is the long String.  */
            languages.put("Java", "A compiled high level, object-oriented platform independent language.  ");
            System.out.println("Java added successfully.  ");
        }
       languages.put("Python", "An interpreted, object-oriented, high level programming language with dynamic semantics.  ");
        languages.put("Algol", "An algorithmic language.  ");
        /* Prints out null, because these are brand new references with a new key and value pair.  */
        System.out.println(languages.put("BASIC", "Beginners All Purpose Symbolic Instruction Code.  "));
        System.out.println(languages.put("Lisp", "Therein lies madness.  "));

        /* Get the value of the item with key "Java".  */
        System.out.println(languages.get("Java"));

        /* Check if the map contains the key "Java".  */
        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map.  ");
        }
        else {
            languages.put("Java", "This course is about Java.  ");
        }

        /* Update the value of the item with key "Java".  */
        /* The System.out.println prints out the previous value of "Java", because that is the value that already
        * existed prior to being added so the line gets process.  */
        System.out.println(languages.put("Java", "This course is about Java.  "));
        System.out.println(languages.get("Java"));

        /* Remove item with key "Lisp" from the map.  */
        languages.remove("Lisp");

        /* remove() method returns false, the key match but value doesn't match.  */
        if(languages.remove("Algo", "A family of algorithmic languages.  ")) {
            System.out.println("Algol removed.  ");
        }
        else {
            System.out.println("Algol not removed, key / value pair not found.  ");
        }

        /* Re-add the item with key "Lisp" to the list.  */
        languages.put("Lisp", "Therein lies madness.  ");
        /* Replace Lisp's old definition.  */
        if(languages.replace("Lisp", "Therein lies madness.  ", "A functional programming language with imperative features.  ")) {
            System.out.println("Lisp replaced.  ");
        }
        else {
            System.out.println("Lisp was not replaced.  ");
        }

        /* "Scala" doesn't exist in the map, so nothing changes.   */
        System.out.println(languages.replace("Scala", "This will not be added.  "));

        System.out.println("========================================");

        /* Iterate through and print out the key-value pairs.  */
        for(String key : languages.keySet()) {
            System.out.println(key + ":  " + languages.get(key));
        }
    }

}
