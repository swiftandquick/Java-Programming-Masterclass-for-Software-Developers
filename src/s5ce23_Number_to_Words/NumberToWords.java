package s5ce23_Number_to_Words;

public class NumberToWords {

    /* Get the number of digits.  */
    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        else if (number == 0) {
            return 1;
        }
        else {
            int digits = 0;
            /* For loop stops if i is equal to 0, which means i is less than 10 in the previous iteration.
            * For example 9 / 10 = 0, and loop will end in the next iteration.  */
            for (int i = number; i > 0; i = i / 10) {
                digits++;
            }
            return digits;
        }
    }


    public static int reverse(int number) {
        if (number == 0) {
            return 0;
        }
        else {
            int reverse = 0;
            /* For positive numbers.  */
            if (number > 0) {
                for (int i = number; i > 0; i = i / 10) {
                    reverse = reverse * 10 + i % 10;
                }
            }
            /* For negative numbers.  */
            else {
                /* i = -121, reverse = 0 * 10 + -121 % 10 = 0 + -1 = -1.
                 * i = -12, reverse = -1 * 10 + -12 % 10 = -10 + -2 = -12.
                 * i = -1, reverse = -12 * 10 + -1 % 10 = -120 + -1 = -121.
                 * i = 0, exit out of the loop with reverse = -121.  */
                for (int i = number; i < 0; i = i / 10) {
                    reverse = reverse * 10 + i % 10;
                }
            }
            return reverse;
        }
    }


    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }
        else {
            /* Turn the number into char array.  */
            char[] numberCA = (number + "").toCharArray();
            /* Use for loop to print out each char (represents number) in words.  */
            for (int i = 0; i < numberCA.length; i++) {
                switch(numberCA[i]) {
                    case '0':
                        System.out.print("Zero ");
                        break;
                    case '1':
                        System.out.print("One ");
                        break;
                    case '2':
                        System.out.print("Two ");
                        break;
                    case '3':
                        System.out.print("Three ");
                        break;
                    case '4':
                        System.out.print("Four ");
                        break;
                    case '5':
                        System.out.print("Five ");
                        break;
                    case '6':
                        System.out.print("Six ");
                        break;
                    case '7':
                        System.out.print("Seven ");
                        break;
                    case '8':
                        System.out.print("Eight ");
                        break;
                    case '9':
                        System.out.print("Nine ");
                        break;
                    default:
                        break;
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        System.out.println(getDigitCount(0));
        System.out.println(getDigitCount(123));
        System.out.println(getDigitCount(-12));
        System.out.println(getDigitCount(5200));

        System.out.println(reverse(-121));
        System.out.println(reverse(1212));
        System.out.println(reverse(1234));
        System.out.println(reverse(100));

        numberToWords(123);
        numberToWords(1010);
        numberToWords(1000);
        numberToWords(-12);
    }

}
