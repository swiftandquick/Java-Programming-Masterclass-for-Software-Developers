package s18_314_Introduction_to_Debugging;

public class StringUtilities {

    private StringBuilder sBuilder = new StringBuilder();
    /* charsAdded() is initially 0.  */
    private int charsAdded = 0;


    /* Every time addChar() is called, append character to sBuilder and increment charsAdded by 1.  */
    public void addChar(StringBuilder sBuilder, char c) {
        /* Append character to sBuilder from argument, not sBuilder the instance variable.  */
        sBuilder.append(c);
        charsAdded++;
    }


    public String upperAndPrefix(String str) {
        String upper = str.toUpperCase();
        return "Prefix_" + upper;
    }


    public String addSuffix(String str) {
        return str + "_Suffix";
    }

}
