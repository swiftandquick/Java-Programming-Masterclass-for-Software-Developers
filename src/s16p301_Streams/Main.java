package s16p301_Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<String>();

        /*
        someBingoNumbers.forEach(number -> {
            // startsWith():  Checks if this string starts with given prefix, returns true if it does, false otherwise.
            // In this case, checks if String starts with "G".
            if(number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        // Sort the gNumbers objects in alphabetical order.
        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));

        // Print out each object in gNumbers.
        gNumbers.forEach((String s) -> System.out.println(s));
         */

        /* Stream version of the commented out code.
        stream():  Initiate the stream.
        map():  Returns a stream consisting of the results of applying the given function to the elements of this
        stream.  In this case, use String to call the toUpperCase() method.
        filter():  Returns a stream consisting of the elements of this stream that match the given predicate.  In this
        case, returns String (s) start with G.
        sorted():  Returns a stream consisting of the elements of this stream, sorted according to natural order.
        forEach():  Performs an action for each element of this stream.  In this case, use System.out to call the
        println() method, print out each element of this stream.
        :: is method reference.
        */
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        /* Stream:  A sequence of elements supporting sequential and parallel aggregate operations.
        * Stream.of():  In this case, returns a sequential ordered stream whose elements are the specified values.  */
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");

        /* concat():  Create a concatenated stream whose elements are all the elements of the first stream
        (ioNumberStream) followed by all the elements of the second stream (inNumberStream).  */
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        /* distinct():  Remove duplicated items from the stream.
        peek():  Returns a stream consisting of the elements of this stream, additionally prints out the items in this case.
        count():  Count the number of elements in the Stream object (concatStream) after item removal.  */
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<Department>();
        departments.add(hr);
        departments.add(accounting);

        /* flatMap():  Returns a stream consisting of the results of replacing each element of this stream with the
        contents of a mapped stream produced by applying the provided mapping function to each element.  In this case,
        pass department (Department object) as argument, then returns a stream of the objects in List<Employee>
        (department.getEmployees()).
        forEach():  Print out each element in the Employee object's stream.  */
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        /* Return each String to upper case, checks if each String starts with G, then alphabetically sort the Strings.
        * collect():  Performs a mutable reduction operation on the elements of this stream using a Collector.
        * In this case, transform the stream of items into a List.  */
        /*
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());
         */

        /* collect():  Performs a mutable reduction operation on the elements of this stream.
        * Array::new:  The supplier, the supplier creates object, so this creates a new ArrayList.
        * ArrayList::add:  Accumulator, add the item to the ArrayList.
        * ArrayList::addAll:  Combiner, improve the efficiency of the operation.  */
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for(String s : sortedGNumbers) {
            System.out.println(s);
        }

        /* flatMap():  Get the stream for the List<Employees> from department object.
        * collect():  Performs a mutable reduction operation on the elements of this stream using a Collector.
         * groupingBy():  Combine all the items in a String into a single result.  */
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        /* flatMap():  Get the stream for the List<Employees> from department object.
        * reduce():  Compares the age of two employees, returns the younger employee.  Result of this method will be
        * the youngest employee in the stream.
        * isPresent():  It's not a stream method, which is call onto the stream chain result to print the result.  */
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        /* filter():  Filter out the list of items in stream and return stream of items (String) with length of 3.
        * count():  Returns the count of elements in this stream.  */
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }

}
