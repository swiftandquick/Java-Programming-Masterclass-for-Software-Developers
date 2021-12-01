package s17_306_Regular_Expressions_Introduction;

import s11p148_Scope_Challenge_Exercise.X;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string.  Yes, I am.  ";
        System.out.println(string);
        /* Replace all “I” with “You” in the String string.  */
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        /* Replace all characters with “Y”.  */
        System.out.println(alphanumeric.replaceAll(".", "Y"));

        /* Replace "abcDeee" at the start of the String with "YYY".  */
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";
        /* Second occurrence of "abcDeee" isn't replaced by "YYY".
        * ^:  Finds a match as the beginning of a string as in:  ^abcDeee.  */
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        /* matches():  Tells whether or not this String matches the given regular expression.
        * In this case, "hello" doesn't match the alphanumeric String, so return false.  */
        System.out.println(alphanumeric.matches("^hello"));

        /* While "abcDeee" is in the beginning of the String, it doesn't match the entire String, return false.  */
        System.out.println(alphanumeric.matches("^abcDeee"));

        /* Return true since the entire String matches.  */
        System.out.println(alphanumeric.matches("^abcDeeeF12Ghhiiiijkl99z"));

        /* Replace "ijkl99z" at the end of the String with "THE END".
        * Finds a match at the end of the string as in:  ijkl99z$.  */
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));

        /* Replace all characters 'a', 'e', and 'i' with "X".
        * [abc]:  Find one character from the options between the brackets.  */
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));

        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));

        /* Replace two characters, the first character must be 'a', 'e', or 'i', the second character must be 'F' or
        'j'.  For example 'eF' and 'ij' will be replaced by "X", but 'ee' won't be replaced by "X" because the second
         character isn't 'F' or 'j'.  */
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        /* Replace "Harry" or "harry" with "Harry".  */
        System.out.println("Harry".replaceAll("[Hh]arry", "Harry"));

        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        /* Replace all characters that are not 'e' or 'j' with "X".
        * [^abc]:  Find one character NOT between the brackets.  */
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));

        /* Replace characters inside [] with "X".  */
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));

        /* Replace characters range between 'a' and 'f', range between 'A' and 'F'm and range between '3' and '8' with
        "X".  */
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));

        /* Replace characters inside [] with "X".  Ignore cases.  */
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));

        /* Replace characters between '0' and '9' with "X".  */
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));

        /* Replace all digits with "X".  */
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));

        /* Replace all non-digits with "X".  */
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhiteSpace);

        /* Remove all white space in the String.  */
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));

        /* Replace a tab character with "X".  */
        System.out.println(hasWhiteSpace.replaceAll("\t", "X"));

        /* Remove all non white space in the String.  */
        System.out.println(hasWhiteSpace.replaceAll("\\S", ""));

        /* Replace word characters ('a' to 'z', 'A' to 'Z', '0' to '9') with "X".  */
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));

        /* Replace word characters (not include tab, white space, and new line), with "X".  */
        System.out.println(hasWhiteSpace.replaceAll("\\w", "X"));

        /* Add "X" in the beginning and end of each word.  */
        System.out.println(hasWhiteSpace.replaceAll("\\b", "X"));

        String thirdAlphanumericString = "abcDeeeF12Ghhiiiijkl99z";

        /* Replace "abcDeee" at the beginning with "YYY", 'e' occurs 3 times.  */
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}", "YYY"));

        /* Replace "abcDeeee" at the beginning with "YYY", the following 'e' characters after the first 'e' are replaced.  */
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+", "YYY"));

        /* Remove the 'e' from the thirdAlphanumericString.  */
        // thirdAlphanumericString = "abcDF12Ghhiiiijkl99z";

        /* Match String begin with "abcD", follow by zero or more 'e', then replace that part with "YYY".  */
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*", "YYY"));

        /* Remove 2 'e' from the thirdAlphanumericString.  */
        // thirdAlphanumericString = "abcDeF12Ghhiiiijkl99z";

        /* Match String begin with "abcD", follow by 2 to 5 'e', then replace that part with "YYY".  */
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}", "YYY"));

        /* Match 1 or more occurrence of 'h', plus zero or more occurrence of 'i', plus 'j'.  Replace that with "Y".  */
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j", "Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        /* Represents that there are characters before <h2> and after <h2>.  */
        // String h2Pattern = ".*<h2>.*";
        String h2Pattern = "<h2>";
        /* Pattern:  A compiled representation of a regular expression.
        * compile():  Compiles the given regular expression into a pattern.  */
        Pattern pattern = Pattern.compile(h2Pattern);
        /* Matcher:  An engine that performs match operations on a character sequence by interpreting a Pattern.  */
        Matcher matcher = pattern.matcher(htmlText);
        /* matches():  Attempts to match the entire region against the pattern.  It should match and return true because
        there is “<h2>” and there are characters before and after “<h2>”.  */
        System.out.println(matcher.matches());

        /* Reset the Marcher.  */
        matcher.reset();

        int count = 0;
        /* Attempts to find the next subsequence of the input sequence that matches the pattern.  Returns boolean.  */
        while(matcher.find()) {
            count++;
            /* start():  Returns the start index of the previous match.
            * end():  Returns the offset after the last character matched.  */
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        /* One or more characters between <h2> and </h2>.  */
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        /* group(int group):  Returns the input subsequence captured by the given group during the previous match
        operation.  group(0) is the entire character sequence, group(1) is "(<h2>.*?</h2>)" group.  */
        while(groupMatcher.find()) {
            System.out.println("Occurrence:  " + groupMatcher.group(1));
        }

        /* Get the String in between the <h2> tags.  */
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence:  " + h2TextMatcher.group(2));
        }

        /* Replace "Harry" or "harry" with "Larry".  */
        System.out.println("harry".replaceAll("[H|h]arry", "Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry", "Larry"));

        String tvTest = "tstvtkt";
        /* The pattern includes 't', then there can be no next character, but the next character can't be 'v'.  */
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        /* While I can find the pattern inside tvTest, print out the start index and the index after the end index
        * of the occurrence.  "ts", "tk", and "t".  */
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890"; // Shouldn't match.
        String phone2 = "(123) 456-7890"; // Should match.
        String phone3 = "123 456-7890"; // Shouldn't match.
        String phone4 = "(123)456-7890"; // Shouldn't match.

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        String visa1 = "4444444444444"; // Should match.
        String visa2 = "5444444444444"; // Shouldn't match.
        String visa3 = "4444444444444444";  // Should match.
        String visa4 = "4444";  // Shouldn't match.

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));
    }

}
