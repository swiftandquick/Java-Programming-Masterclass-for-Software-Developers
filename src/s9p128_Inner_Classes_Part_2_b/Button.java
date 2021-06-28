package s9p128_Inner_Classes_Part_2_b;

public class Button {

    private String title;
    /* OnClickListener is an interface, which can be used as an object type.  */
    private OnClickListener onClickLister;


    /* Takes title as argument as sets title, title is "Print."  */
    public Button(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }


    public void setOnClickListener(OnClickListener onClickListener) {
        onClickLister = onClickListener;
    }


    /* Use the OnClickListener type object, onClickLister, to invoke the onClick method, pass in title, which
    * is "Print" as argument.  This is overrides the inner class' onClick() method.  */
    public void onClick() {
        onClickLister.onClick(title);
        System.out.println(title);
    }


    /* Inner interface, with an abstract method that is meant to be overridden.  */
    public interface OnClickListener {
        public void onClick(String title);
    }

}
