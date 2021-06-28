package s5ce15_Number_Palindrome;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        /* Palindrome ignore negative signs, so I set number equal to its absolute value if it's negative.  */
        if (number < 0) {
            number = number * -1;
        }

        /* Set up a StringBuilder to reverse a String later on.  */
        StringBuilder input = new StringBuilder();

        /* Append the number to input StringBuilder.  */
        input.append(number);

        /* Reverse the StringBuilder object input.  */
        input.reverse();

        /* Convert reversed String back to integer.  */
        int reverse = Integer.parseInt(input.toString());

        /* If the reverse equals to the original, then it's a palindrome.  */
        if (number == reverse) {
            return true;
        }
        else {
            return false;
        }

    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(-1221));
        System.out.println(isPalindrome(707));
        System.out.println(isPalindrome(11212));
    }

}
