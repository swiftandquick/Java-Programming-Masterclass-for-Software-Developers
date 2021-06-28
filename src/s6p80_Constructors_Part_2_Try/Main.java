package s6p80_Constructors_Part_2_Try;

public class Main {

    public static void main(String[] args) {

        VipCustomer c1 = new VipCustomer();
        System.out.println(c1.getName());
        System.out.println(c1.getCreditLimit());
        System.out.println(c1.getEmail());

        VipCustomer c2 = new VipCustomer("John Doe", 10000.00);
        System.out.println(c2.getName());
        System.out.println(c2.getCreditLimit());
        System.out.println(c2.getEmail());

        VipCustomer c3 = new VipCustomer("Jane Doe", 15000.00, "def456@yahoo.com");
        System.out.println(c3.getName());
        System.out.println(c3.getCreditLimit());
        System.out.println(c3.getEmail());

    }

}
