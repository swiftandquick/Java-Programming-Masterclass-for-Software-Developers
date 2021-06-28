package s6p85_Method_Overloading_VS_Overriding_Recap_c;

class BurgerFactory {

    public Burger createBurger() {
        return new Burger();
    }

}


class HealthyBurgerFactory extends BurgerFactory {

    /* Covariant return type in method overriding, HealthyBurger is subclass of Burger.
    * createBurger can return any child type of Burger, includes HealthyBurger.  */
    @Override
    public HealthyBurger createBurger() {
        return new HealthyBurger();
    }

}