package s16p297_Functional_Interfaces_and_Predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee("Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);
        Employee red = new Employee("Red Ridinghood", 35);
        Employee charming = new Employee("Prince Charming", 31);

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);
        employees.add(red);
        employees.add(charming);

        System.out.println("Employees over 30:  ");
        /* Print out employees that are over 30.  */
        for(Employee employee : employees) {
            if(employee.getAge() > 30) {
                System.out.println(employee.getName());
            }
        }

        /* Invoke printEmployeesByAge and pass arguments, set the Predicate as age > 30.  */
        printEmployeesByAge(employees, "Employees over 30", employee -> employee.getAge() > 30);
        /* Set the Predicate as age <= 30.  */
        printEmployeesByAge(employees, "\nEmployees 30 and under", employee -> employee.getAge() <= 30);
        /* Override the test method in Predicate class.  The anonymous object Predicate has an overridden test() method,
        which returns a Boolean, the Boolean is true if employee.getAge() < 25.  */
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        /* IntPredicate:  Represents a predicate (boolean-valued function) of one int-valued argument.  */
        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        /* 10 > 15 is false, return false.  */
        System.out.println(greaterThan15.test(10));

        int a = 20;
        /* 25 > 15 is true, return true.  */
        System.out.println(greaterThan15.test(a + 5));

        /* Use two Predicates at once via and() method.   Both greaterThan15 and lessThan100 have to return true with
         * 50 as the argument.  50 > 15 and 15 < 100, return true.  */
        System.out.println(greaterThan15.and(lessThan100).test(50));

        /* 15 > 15 is false, so if one Predicate is false, the entire statement returns false.  */
        System.out.println(greaterThan15.and(lessThan100).test(15));

        Random random = new Random();
        /* Supplier:  Represents a supplier of results.  Often used with lambda expression.
        * Returns a random integer from 0 to 999.  */
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i = 0; i < 10; i++) {
            /* Get the result.  */
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(' ') + 1);
            System.out.println("Last Name is:  " + lastName);
        });

        /* Function:  Represents a function that accepts one argument and produces a result.
        * Takes Employee object (employee) as argument, return the last name.  */
        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' ') + 1);
        };

        /* getLastName is a Function object, use getLastName to invoke the apply() method to get the last of the
        Employee object (employees.get(2)).  */
        String lastName = getLastName.apply(employees.get(1));
        System.out.println(lastName);

        /* Takes Employee object (employee) as argument, return the first name.  */
        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random1 = new Random();
        for(Employee employee : employees) {
            /* nextBoolean() randomly returns true or false.  If true, get first name, if false, get last name.  */
            if(random1.nextBoolean()) {
                System.out.println(getAName(getFirstName, employee));
            }
            else {
                System.out.println(getAName(getLastName, employee));
            }
        }

        /* A function that transforms the name to upper case.  */
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        /* A function that gets the first name.  */
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(' '));
        /* Chain two functions together, upperCase and firstName.  upperCase returns a name in upper case letters as
        String, then applies the after function (firstName) to the result to get the first name.  */
        Function chainedFunction = upperCase.andThen(firstName);

        /* Get the first name and capitalize it.  */
        System.out.println(chainedFunction.apply(employees.get(0)));

        /* BiFunction:  Represents a function that accepts two arguments and produces a result.  */
        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            /* concat():  Concatenate a String with another String.
            * Concatenate the age next to the name and return the new String.  */
            return name.concat(" " + employee.getAge());
        };

        /* Get the name (in upper case) and age of the employees.get(0).  */
        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        /* IntUnaryOperator:  Represents an operation on a single int-valued operand that produces an int-valued result.
        Takes i as argument and increment i by 5.
        applyAsInt():  Applies this operator to the given operand.  In this case, the operand is 10.  */
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        /* Consumer:  Represents an operation that accepts a single input argument and returns no result.
        * Consumer don't return anything, so the result of the s.toLowerCase() from c1 is actually.  Each consumer in
        * the chain is evaluated independently of the others.   */
        Consumer<String> c1 = s -> s.toLowerCase();
        Consumer<String> c2 = s -> System.out.println(s);
        c1.andThen(c2).accept("Hello, World!");
    }


    private static String getAName(Function<Employee, String> getName, Employee employee) {
        return getName.apply(employee);
    }


    /* Predicate:  Represents a predicate (boolean-valued function) of one argument.   */
    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {

        System.out.println("Employees over 30:  ");
        System.out.println(ageText);
        for(Employee employee : employees) {
            /* ageCondition is Predicate<Employee>.
            * employee is an Employee object.
            * test() method evaluates this predicate on the given argument.  */
            if(ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }

    }
}
