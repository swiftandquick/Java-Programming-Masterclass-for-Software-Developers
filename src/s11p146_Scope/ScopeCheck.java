package s11p146_Scope;

public class ScopeCheck {

    public int publicVar = 0;
    private int privateVar = 1;


    public ScopeCheck() {
        /* Because there is no local variable with the same name, I don't need to use this keyword.  */
        System.out.println("ScopeCheck created. publicVar = " + publicVar + ":  privateVar = " + privateVar);
    }


    public int getPrivateVar() {
        return privateVar;
    }


    public void timesTwo() {
        int privateVar = 2;
        for(int i = 0; i < 10; i++) {
            /* Local variable overrides private variable, privateVar is 2.  */
            System.out.println(i + " times two is " + i * privateVar);
            /* privateVar here is 1, because I use the this keyword to refer to instance variable.  */
            System.out.println(i + " times two is " + i * this.privateVar);
        }
    }


    public class InnerClass {
        public int privateVar = 3;

        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + privateVar);
        }

        public void timesTwo() {
            /* Call the timesTwo() method from ScopeCheck (outer class) class.  */
            ScopeCheck.this.timesTwo();
            for(int i = 0; i < 10; i++) {
                /* There is no local variable to override instance variable again, privateVar is set to instance
                variable, which is 3.  */
                System.out.println(i + " times two is " + i * privateVar);
            }
        }
    }

}
