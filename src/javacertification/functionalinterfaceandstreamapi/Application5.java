package javacertification.functionalinterfaceandstreamapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Application5 {
    public static void main(String[] args) {
        // target type of lambda expression should be a functional interface
        // StringConsumer1 consumer1 = s -> System.out.println();

        int sum = IntStream.rangeClosed(1,3).map(
                i -> i*i
        ).map(i -> i*i).sum();

        // IntStream.rangeClosed(1,3) - for range closed --> both inclusive (1,2,3)
        // IntStream.map (IntUnaryOperator) - returns a stream consisting of the results of
        // applying the given function to the elements of this stream

        // map (i -> i*i) --> {1,4,9}
        // map (i -> i*i) --> {1,16,81}
        // sum () --> 1 + 16 + 81 -- > 98

        System.out.println(sum);

        Certifications c1 = new Certifications("S001", "OCA", 87);
        Certifications c2 = new Certifications("S002", "OCA", 82);
        Certifications c3 = new Certifications("S001", "OCP", 79);
        Certifications c4 = new Certifications("S002", "OCP", 89);
        Certifications c5 = new Certifications("S003", "OCA", 60);
        Certifications c6 = new Certifications("S004", "OCA", 88);

        Stream<Certifications> stream = Stream.of(c1,c2,c3,c4,c5,c6);

        // we have to do s.getTest().equals ("OCA") - since the lambda expression
        // is of partitioning type and not a string
        Map<Boolean, List<Certifications>> map = stream
                .collect(Collectors.partitioningBy(s -> s.getTest().equals
                        ("OCA")));

        System.out.println(map.get(true));

        Stream<Integer> integerStream = Stream.iterate(1, i-> i+1);
        System.out.println(integerStream.anyMatch(i -> i>1));

        // stream => {1,2,3,4,5.....} infinite stream
        // Predicate --> i -> i >1 - return true for any integer greater than 1
        // As 2>1, so true is printed and operation is terminated.

        // Note : stream.allMatch(i -> i>1) -> will return false for stream (1)
        // stream.noneMatch (i -> i>1) returns false as 2nd element of the stream (2)
        // return true for the predicate

        List<String> list = new ArrayList<>(Arrays.asList("Z", "Y", "X"));
        list.stream().sorted().findFirst().get();
        // the below expression will return 'X' because stream in above expression
        // will have no impact on list, since they both the separate
        System.out.println(list.get(2));

        System.out.println(list.stream().findFirst().get());

        // findAny () will return any result from the stream and as stream is not
        // parallel, it will most likely return first element, but this is not the
        // guaranteed result. and since stream has 3 elements, it will never call orElse (// element)
        System.out.println(Stream.of(10,0,-10).sorted().findAny().orElse(-1));

        // if we do not include limit () than it will generate an infinite stream of double numbers
        // and since sorted needs all elements to be available, which will not be the case here,
        // sorted () will never end and hence infinite loop
        Stream<Double> doubleStream = Stream.generate(
                () -> new Double("1.0")).limit(10);

        System.out.println(doubleStream.sorted().findFirst().get());

        Stream<Double> doubleStream1 = Stream.generate(
                () -> new Double("1.0")).limit(10);

        System.out.println(doubleStream1.filter(d -> d>2).anyMatch(d -> d==2));

        List<Integer> integerList = Arrays.asList(-80,100,-40,25,200);
        Predicate<Integer> predicate = num -> {
            int ctr = 1;
            boolean result = num > 0;
            System.out.print(ctr++ + ".");
            return result;
        };
        integerList.stream().filter(predicate).forEach(System.out::print);

        System.out.println(" ..... ");

        List<Integer> list1 = Arrays.asList(-80,100,-40,25,200);
        Predicate<Integer> predicate1 = num -> {
          int ctr = 1;
          boolean result = num > 0;
            System.out.print(ctr++ + ".");
            return result;
        };

        // count is terminal operation, so all elements should be printed before it is called
        list1.stream().filter(predicate1).count();

        System.out.println(" ");
        List<Integer> list2 = Arrays.asList(-10,20,-8);
        System.out.println(list2.stream().max(
                Comparator.comparing(a -> a)).get());

        System.out.println(list2.stream().max(Integer::compareTo).get());

        // max accepts two arguments and return int value but in this case, 3 values are used
        // it will not provide correct output
        System.out.println(list2.stream().max(Integer::max).get());

        String [] array =  {"*", "**", "***", "****", "*****", "******"};
        Predicate<String> predicate2 = s -> s.length() > 3;
        print (array, predicate2.negate());

        Person p1 = new Person(1010,"Sean");
        Person p2 = new Person(2843, "Rob");
        Person p3 = new Person(1111, "Lucy");

        Stream<Person> personStream = Stream.of(p1,p2,p3);
        /*Map<Integer, Person> personMap = personStream.collect(
                Collectors.toMap(p -> p.id, Function.identity()));
        System.out.println(personMap.size());*/

        Map<Integer, Person> personMap2 = personStream.collect(
                Collectors.toMap(p -> p.id, p->p));

        System.out.println(personMap2.size());

        Stream<String> stringStream = Stream.of("a","as","an","and");
        Optional<String> first = stringStream.findFirst();
        // isPresent () returns a boolean, where as method ifPresent () accepts a consumer parameter
        /*if (first.ifPresent()) {
        }*/

        Message message = null;
        Optional<Message> optional = Optional.ofNullable(message);
        // new Message () --> will call toString() method which will return the object value (Good Morning!!)
        System.out.println(optional.isPresent() ? optional.get().getMsg() : new Message());


    }

    private static void print (String [] arr, Predicate<String> predicate) {
        for (String str : arr) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }
    }
}
