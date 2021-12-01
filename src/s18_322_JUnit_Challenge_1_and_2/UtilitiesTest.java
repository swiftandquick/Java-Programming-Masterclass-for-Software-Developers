package s18_322_JUnit_Challenge_1_and_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities util = new Utilities();


    /* Set up method for test cases.  Not sure why this doesn't work.  */
    @org.junit.Before
    public void setup() {
        util = new Utilities();
    }


    @Test
    public void everyNthChar() throws Exception {
        char[] output = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);
        assertArrayEquals(new char[] {'e', 'l'}, output);
        /* When String's length is less than n.  */
        char[] output2 = util.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 8);
        assertArrayEquals(new char[] {'h', 'e', 'l', 'l', 'o'}, output2);
    }


    @Test
    public void removePairs() throws Exception {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        /* Checks if expected output is null base on actual result.  When String is null.  */
        assertNull(util.removePairs(null), "Did not get null returned when argument passed was null.  ");
        /* When String's length is less than 2.  */
        assertEquals("A", util.removePairs("A"));
        /* When String is empty.  */
        assertEquals("", util.removePairs(""));
    }


    @Test
    public void converter() throws Exception {
        assertEquals(300, util.converter(10, 5));
    }


    @Test
    public void converter_arithmeticException() throws Exception {
        try {
            util.converter(10, 0);
        }
        catch(ArithmeticException e) {
        }
    }


    @Test
    public void nullIfOddLength() throws Exception {
        assertNull(util.nullIfOddLength("odd"));
        /* Checks if expected output is not null.  */
        assertNotNull(util.nullIfOddLength("even"));
    }
}