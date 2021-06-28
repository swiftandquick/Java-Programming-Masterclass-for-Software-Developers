package s6p85_Method_Overloading_VS_Overriding_Recap;

/* Method overriding.  */

class Dog {

    public void bark() {
        System.out.println("woof");
    }

}


class GermanShepherd extends Dog {

    @Override
    /* Method with same name and same parameters overrides the method of its superclass.  */
    public void bark() {
        System.out.println("woof woof woof");
    }

}