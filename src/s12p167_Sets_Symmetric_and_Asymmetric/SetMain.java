package s12p167_Sets_Symmetric_and_Asymmetric;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    private static void printSet(Set<String> set) {
        System.out.println("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Set<Integer> squares = squares = new HashSet<Integer>();
        Set<Integer> cubes = new HashSet<Integer>();

        for(int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes.  ");

        /* Add all items in squares to the union Set.  */
        Set<Integer> union = new HashSet<Integer>(squares);
        /* Add all items in cubes to the union Set.  */
        union.addAll(cubes);

        /* Because some of the results in squares and cubes are equal, I can't get a total of 200 items in union Set.  */
        System.out.println("Union contains " + union.size() + " elements.  ");

        Set<Integer> intersection = new HashSet<Integer>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.  ");
        for(int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube root of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<String>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");

        /* Turns arrayWords into a list then use addAdd() method to add all items into the words set.  */
        words.addAll(Arrays.asList(arrayWords));

        for(String word : words) {
            System.out.println(word);
        }

        Set<String> nature = new HashSet<String>();
        Set<String> divine  = new HashSet<String>();

        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine:  ");
        Set<String> diff1 = new HashSet<String>(nature);
        /* Remove the common items ("is" and "to") and only unique items in diff1 (nature) remains.  */
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:  ");
        Set<String> diff2 = new HashSet<String>(divine);
        /* Remove the common items ("is" and "to") and only unique items in diff2 (divine) remains.  */
        diff2.removeAll(nature);
        printSet(diff2);

        /* Get the union of both Sets.  */
        Set<String> unionTest = new HashSet<String>(nature);
        unionTest.addAll(divine);

        /* Get the common items of both Sets.  */
        Set<String> intersectionTest = new HashSet<String>(nature);
        intersectionTest.retainAll(divine);

        /* Get the unique items of both Sets.  */
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        /* Checks if divine is nature's subset, which isn't.  */
        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature.  ");
        }

        /* Checks if intersectionTest is a subset of nature, which is.  */
        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature.  ");
        }

        /* Checks if intersectionTest is a subset of divine, which is.  */
        if(divine.containsAll(intersectionTest))
            System.out.println("intersection is a subset of divine.  ");
    }

}
