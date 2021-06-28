package s11p146_Scope;

public class Main {

    public static void main(String[] args) {
        String privateVar = "This is private to main().  ";

        ScopeCheck scopeInstance = new ScopeCheck();

        /* privateVar in ScopeCheck can't be directly accessed by Main class, I have to invoke getter to retreive it.  */
        System.out.println("scopeInstance privateVar is " + scopeInstance.getPrivateVar());

        /* Prints out privateVar String from Main class.  */
        System.out.println(privateVar);

        scopeInstance.timesTwo();

        System.out.println("------------------");

        /* Create this object to gain access to InnerClass' variables and invoke methods from InnerClass.  */
        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }

}
