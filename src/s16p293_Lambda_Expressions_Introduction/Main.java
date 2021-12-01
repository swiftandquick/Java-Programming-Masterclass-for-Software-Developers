package s16p293_Lambda_Expressions_Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /* This is the Lambda Expression.  run() has no argument so argument list is empty.  */
        new Thread(() -> {
            /* Body of a Lambda expression.  */
            System.out.println("Printing from the Runnable.  ");
            System.out.println("Line 2.  ");
            System.out.format("This is line.  %d\n", 3);
        }).start();

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        /* Sort the List employees in alphabetical order.  */
        /*
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                return employee1.getName().compareTo(employee2.getName());
            }
        });
         */

        /* Lambda expression version of the above code.
        * I don't have declare type for employee1 and employee2, program assumes that it's Employee type.  */
        Collections.sort(employees, (employee1, employee2) ->
                employee1.getName().compareTo(employee2.getName()));

        for(Employee employee : employees) {
            System.out.println(employee.getName());
        }

        /* Combine upper case of two employees' names.  */
        /*
        String sillyString = doStringStuff(new UpperConcat() {
            @Override
            public String upperAndConcat(String s1, String s2) {
                return s1.toUpperCase() + s2.toUpperCase();
            }
        }, employees.get(0).getName(), employees.get(1).getName());
         */

        /* Lambda expression version.
        Create an UpperConcat object uc that takes two String as arguments, then concatenate them.  Then invoke
        the doStringStuff method, pass in uc (UpperConcat object) and two String (employees' names) as argument.
        upperAndConcat() method is invoked, and two String are join together and is capitalized.  */
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
        String sillyString = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
        System.out.println(sillyString);

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