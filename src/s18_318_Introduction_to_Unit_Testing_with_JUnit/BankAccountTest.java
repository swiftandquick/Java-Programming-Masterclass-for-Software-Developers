package s18_318_Introduction_to_Unit_Testing_with_JUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static junit.framework.TestCase.*;

/**
 * Created by timbuchalka on 20/11/16.
 */
public class BankAccountTest {

    private BankAccount account;
    private static int count;


    /* When we want to execute an expensive common operation before each test, it's preferable to execute it only once
    before running all tests using @BeforeClass.  */
    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases.  Count = " + count++);
    }


    /* Methods annotated with the @Before annotation are run before each test.  */
    @Before
    /* Set up the account object's instance variables.  */
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @org.junit.Test
    public void deposit() throws Exception {
        /*
        // fail():  Used inside a JUnit method, accepts a String parameter that it will report when the test fails.
        fail("This test has yet to be implemented");
         */
        double balance = account.deposit(200.00, true);
        /* Checks if balance equals to 1200.  The 0 is the delta value.  If the difference between balance (actual)
         * and 1200.00 (expected) is less than or equal to 0, the test passes.  */
        assertEquals(1200.00, balance, 0);
        assertEquals(1200.00, account.getBalance(), 0);
    }


    /* Expect the test to throw IllegalArgumentException, can pass the test even if IllegalArgumentException is thrown.   */
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        // I withdraw over 500 dollars at an ATM (false), which should result IllegalArgumentException.
        account.withdraw(600.00, false);
        fail("Should have thrown an IllegalArgumentException.  ");
    }


    @org.junit.Test
    public void getBalance_deposit() throws Exception {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }


    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }


    @org.junit.Test
    public void isChecking_true() {
        assertEquals(true, account.isChecking());
    }


    /*
    @org.junit.Test
    public void dummyTest() {
        // Assert 2 int variable are equal, 20 is the value we expect, 21 is the actual value.
        // It should result an error because expected value and actual value are different.
        assertEquals(20, 21);
    }
     */


    /* Annotating a method with @AfterClass causes it to be run after all the tests in the class have been run.  All
    @AfterClass methods are guaranteed to run even if a BeforeClass method throws an exception.  */
    @AfterClass
    public static void AfterClass() {
        System.out.println("This executes after any test cases.  Count = " + count++);
    }


    /* Annotating a method with @After causes it to be run after the Test method.  All @After methods are guaranteed to
    run even if a Before or Test method throws an exception.  */
    @After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

}