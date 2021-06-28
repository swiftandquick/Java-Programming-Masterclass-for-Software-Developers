package s11p146_Scope_Part_2;

public class Main {

    public static void main(String[] args) {
        String varFour = "This is private to main().  ";

        ScopeCheck scopeInstance = new ScopeCheck();

        /* Call the useInner() method from ScopeCheck class.  */
        scopeInstance.useInner();

        // ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();

        /* Main is not an outer class for InnerClass and varThree is a private variable, I can't access varThree.  */
        // System.out.println("varThree is not accessible here " + innerClass.varThree);

        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());

        System.out.println(varFour);

        scopeInstance.timesTwo();

        System.out.println("------------------");

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }

}
