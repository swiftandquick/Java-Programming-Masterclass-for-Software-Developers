package s6p85_Method_Overloading_VS_Overriding_Recap_b;

/* Method overloading.  */

class Dog {

    public void bark() {
        System.out.println("woof");
    }

    /* Same name, different parameters.  */
    public void bark(int number) {
        for (int i = 0; i < number; i++) {
            System.out.println("woof");
        }
    }

}
