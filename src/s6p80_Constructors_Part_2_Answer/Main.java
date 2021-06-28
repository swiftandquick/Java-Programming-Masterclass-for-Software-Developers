package s6p80_Constructors_Part_2_Answer;

public class Main {

    public static void main(String[] args) {

        /* Call the constructor without parameters.  */
        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        /* Call the constructor with two parameters.  */
        VipPerson person2 = new VipPerson("Bob", 25000.00);
        System.out.println(person2.getName());

        /* Call the constructor with three parameters.  */
        VipPerson person3 = new VipPerson("Tim", 100.00, "tim@email.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmailAddress());
    }

}
