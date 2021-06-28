package s9p131_Abstract_Classes_Part_2;

/* Abstract class, allows abstract methods.  */
public abstract class Animal {

    private String name;


    public Animal(String name) {
        this.name = name;
    }


    /* Abstract method, or methods without a body.  */
    public abstract void eat();


    public abstract void breathe();


    /* Abstract class also allows regular methods, such as the getter method.  */
    public String getName() {
        return name;
    }

}
