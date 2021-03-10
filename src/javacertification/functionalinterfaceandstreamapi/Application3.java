package javacertification.functionalinterfaceandstreamapi;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class MyException extends RuntimeException {}
class MyException1 extends Exception {}

public class Application3 {
    public static void main(String[] args) throws MyException1 {
        Stream<String> stream =  Stream.of ("and", "Or", "not", "Equals", "unary", "binary");
        Optional<String> optional =
                stream.filter(((Predicate<String>)Application3::isFirstCharVowel)
                        .negate()).findFirst();

        System.out.println(optional.get());

        List<Point> points = new ArrayList<>();
        points.add(new Point(0,0));
        points.add(new Point(1,2));
        points.add(new Point(-1,-1));

        points.stream().filter(Point::filter).forEach(System.out::println);

        List<Rope> ropes = new ArrayList<>();
        ropes.add(new Rope(5,"red"));
        ropes.add(new Rope(10,"Red"));
        ropes.add(new Rope(7,"RED"));
        ropes.add(new Rope(10, "green"));
        ropes.add(new Rope(7,"Blue"));

        ropes.stream().filter(new Rope.Ropefilter()::filter).
                    forEach(System.out::println);

        Stream<LocalDate> localDateStream = Stream.of(LocalDate
        .of(2018,1,1),
                LocalDate.of(2018,1,1));

        Optional<LocalDate> optional1 = localDateStream.distinct().findAny();

        System.out.println(optional1.isPresent() + ":" + optional1.get());

        OptionalLong optionalLong = OptionalLong.empty();
        // this will throw an exception --> No value present (for Long)
        // System.out.println(optionalLong.isPresent() + "" + optionalLong.getAsLong());

        OptionalDouble optionalDouble = OptionalDouble.empty();
        // it will throw an instance of MyException  (since it is extending
        // run time exception)
        // System.out.println(optionalDouble.orElseThrow(MyException::new));

        OptionalInt optionalInt = OptionalInt.empty();
        // it is a checked exception
        // so we have to add it to method signature (
        // of have to put it in a try catch block)
        // System.out.println(optionalInt.orElseThrow(MyException1::new));

        IntStream intStream = IntStream.generate(
                () -> new Random().nextInt(100)).limit(5);
        intStream.filter(i -> i>0 && i< 10).findFirst().ifPresent(System.out::println);

        IntStream intStream1 = new Random().ints(1,7)
                .limit(2);
        System.out.println(intStream1.max().getAsInt());

        Stream<Employee> employeeStream = Stream.of(new Employee("Jack", 10000),
                new Employee("Lucy", 12000),
                new Employee("Tom", 7000));
        highestSalary (employeeStream);

        int sum = IntStream.rangeClosed(1,3).map(i -> i*i).map(i-> i*i).sum();
        System.out.println(sum);

        Stream<Integer> integerStream = Arrays.asList(1,2,3,4,5).stream();
        // there is no method sum in stream class
        // System.out.println(integerStream.sum());
        System.out.println(integerStream.reduce(0,(a,b) -> a+b));

        Stream<Integer> integerStream1 = Arrays.asList(1,2,3,4,5).stream();
        // there is no getAsInt method in stream class
        /*System.out.println(
                integerStream1.mapToInt(i -> i).average().getAsInt();*/

        System.out.println(
                integerStream1.mapToInt(i -> i).average().getAsDouble()
        );

        IntStream intStream2 = IntStream.rangeClosed(1,20).filter(i -> i%2 == 0);
        System.out.println(intStream2.summaryStatistics());

        String text = "I am going to pass OCP exam in first attempt";
        Stream<String> stringStream = Arrays.stream(text.split(" "));
        IntSummaryStatistics intSummaryStatistics =  stringStream.mapToInt(s -> s.length()).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());

    }

    private static void highestSalary (Stream<Employee> employeeStream) {
        System.out.println(employeeStream
        .map(e -> e.getSalary()).max(Employee::salaryCompare));
    }

    private static boolean isFirstCharVowel(String s) {
        s = s.substring(0,1).toUpperCase();
        switch (s) {
            case "A" :
            case "E" :
            case "I" :
            case "O" :
            case "U" :
                return true;
        }
        return false;
    }
}
