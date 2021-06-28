package s6p80_Constructors_Part_2_Try;

public class VipCustomer {

    private String name;
    private double creditLimit;
    private String email;


    public VipCustomer() {
        this.name = "Default Name";
        this.creditLimit = 0;
        this.email = "Default Email";
    }


    public VipCustomer(String name, double creditLimit) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = "Default Email";
    }


    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }


    public String getName() {
        return name;
    }


    public double getCreditLimit() {
        return creditLimit;
    }


    public String getEmail() {
        return email;
    }

}
