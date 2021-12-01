package s17_311_Regular_Expressions_Challenge_Part_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /* Matches because two String are exactly the same.  */
        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));

        /* Regular expression starts with "I want a " and ends with ".", any letter or number in between.  */
        String regExp = "I want a \\w+.+";
        System.out.println(challenge1.matches(regExp)); // Should match.
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regExp)); // Should match.

        /* Same as above, but replace \\w+ with choices between "bike" and "ball".  */
        String regExp1 = "I want a (bike|ball).";
        System.out.println(challenge1.matches(regExp1)); // Should match.
        System.out.println(challenge2.matches(regExp1)); // Should match.

        String regExp3 = "I want a \\w+.";
        Pattern pattern = Pattern.compile(regExp3);

        /* Compares challenge1 (String) with pattern of regExp3.  */
        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches()); // Should match.

        /* Compares challenge2 (String) with pattern of regExp3.  */
        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches()); // Should match.

        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll(" ", "_"));
        System.out.println(challenge4.replaceAll("\\s", "_"));

        String challenge5 = "aaabccccccccdddefffg";
        /* Checks if the String has one or more characters of 'a', 'b', 'c', 'd', 'e', 'f', or 'g'.  */
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));
        /* Start with 3 'a', follow by 'b', then 8 'c', then 3 'd', then 'e', then 3 'f', and finally 'g'.  */
        System.out.println(challenge5.matches("^a{3}bc{8}d{3}ef{3}g$"));
        /* Replace the String with "REPLACED".  */
        System.out.println(challenge5.replaceAll("^a{3}bc{8}d{3}ef{3}g$", "REPLACED"));

        String challenge7 = "abcd.135";
        /* First half of the String are letters, follow by ".", second half of the String are numbers.  */
        System.out.println(challenge7.matches("^[A-z]+\\.\\d+$"));

        /* For each (letter).(number) pattern, print out the number.  */
        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[A-Za-z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);
        while(matcher8.find()) {
            System.out.println("Occurrence:  " + matcher8.group(1));
        }

        /* Again, extract the number from each pattern.  */
        String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[A-Za-z]+\\.(\\d+)(\t|\n)");
        Matcher matcher9 = pattern9.matcher(challenge9);
        while(matcher9.find()) {
            System.out.println("Occurrence:  " + matcher9.group(1));
        }

        /* Find the start and end index of the numbers.  */
        String challenge10 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[A-Za-z]+\\.(\\d+)(\t|\n)");
        Matcher matcher10 = pattern10.matcher(challenge10);
        while(matcher10.find()) {
            System.out.println("Occurrence:  " + matcher10.start(1) + " end = " + (matcher10.end(1) - 1));
        }

        /* Get the coordinates inside the curly braces.  */
        String challenge11 = "{0, 2}, {0, 5}, {1, 3}, {2, 4} {x, y}, {6, 34}, {11, 12}";
        Pattern pattern11 = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);
        while(matcher11.find()) {
            System.out.println("Occurrence:  " + matcher11.group(1));
        }

        String challenge12 = "11111";
        /* Checks if the String is 5 digits.  */
        System.out.println(challenge12.matches("^\\d{5}$"));

        String challenge13 = "11111-1111";
        /* 5 digits, follow by "-", then 4 digits.  */
        System.out.println(challenge13.matches("^\\d{5}\\-\\d{4}$"));

        /* This time, the last 4 digits are optional, hence the "?".  */
        System.out.println(challenge12.matches("^\\d{5}(-\\d{4})?$"));
        System.out.println(challenge13.matches("^\\d{5}(-\\d{4})?$"));

    }

}
