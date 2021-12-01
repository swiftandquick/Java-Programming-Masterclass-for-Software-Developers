package s16p295_Lambda_Expressions_Nested_Blocks;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AnotherClass anotherClass = new AnotherClass();
        /* Invoke the doSomething() method from AnotherClass class.  */
        String s = anotherClass.doSomething();
        System.out.println(s);

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        /* forEach():  Use with lambda expression to iterate through objects.
        employees:  A list of Employee object.
        employee:  A single employee object.
        In this case I print out the name and age of each Employee object.  */
        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

    }


    public final static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }

}



class Employee {

    private String name;
    private int age;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

}



interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}



class AnotherClass {

    public String doSomething() {
        /*
        System.out.println("The another class' name is:  " + getClass().getSimpleName());
        // Invoke the doStringStuff method in Main class.  Pass in anonymous UpperConcat object, "String1", and
        // "String2" as arguments.
        return Main.doStringStuff(new UpperConcat() {
            // The anonymous UpperConcat object is used to invoke the upperAndConcat() method.  Override the empty
            // method from the interface to concatenate and capitalize s1 ("String1") and s2 ("String2").
            @Override
            public String upperAndConcat(String s1, String s2) {
                System.out.println("The anonymous class' name is:  " + getClass().getSimpleName());
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, "String1", "String2");
         */

        /* Lambda expression version.
        * Create a UpperConcat object uc, and use it to call the upperAndConcat method, pass in two String variable,
        * s1 and s2 as arguments, then concatenate and capitalize both String and return the result.  */
        int i = 0;

        UpperConcat uc = (s1, s2) -> {
            System.out.println("The lambda expression' class is:  " + getClass().getSimpleName());
            System.out.println("i in the lambda expression = " + i);
            String result = s1.toUpperCase() + s2.toUpperCase();
            return result;
        };

        System.out.println("The AnotherClass class' name is:  " + getClass().getSimpleName());
        System.out.println("i = " + i);
        /* Invoke doStringStuff from Main method, pass in uc (UpperConcat), "String1", and "String2" as arguments.  */
        return Main.doStringStuff(uc, "String1", "String2");
    }


    public void printValue() {
        int number = 25;
        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The value is " + number);
        };

        /* Start the thread, use Runnable (r) as argument.  */
        new Thread(r).start();
    }

}