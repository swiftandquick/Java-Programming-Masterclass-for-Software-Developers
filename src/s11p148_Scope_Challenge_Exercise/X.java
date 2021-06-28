package s11p148_Scope_Challenge_Exercise;

public class X {

    private int x;


    public X(int x) {
        this.x = x;
    }


    public void x() {
        /* Instance variable x (what I insert into console) multiply by x (from 1 to 12).  */
        for(int x = 1; x < 13; x++) {
            System.out.println(x + " times " + this.x + " equals " + x * this.x);
        }
    }

}
