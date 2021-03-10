package javacertification.functionalinterfaceandstreamapi;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.Predicate;
import java.util.stream.*;

public class Application4 {
    public static void main(String[] args) {
        int res = 1;
        IntStream intStream = IntStream.rangeClosed(1,5);

        // System.out.println(intStream.reduce(1, (i,j) -> i*j));
        System.out.println(intStream.reduce(res, (i,j) -> i*j));

        IntStream intStream1 = IntStream.rangeClosed(1,4);
        System.out.println(intStream1.reduce(res++, (i,j) -> i*j));

        Stream<String> stringStream = Arrays.asList("one", "two", "three").stream();
        System.out.println(stringStream.reduce(null,(s1,s2) -> s1+s2));

        Stream<Double> doubleStream = Arrays.asList(1.8,2.2,3.5).stream();
        // System.out.println(doubleStream.reduce(Double::sum));

        System.out.println(doubleStream.reduce((d1,d2) -> d1+d2));

        String[] names = {"Peter", "bonita", "John"};
        Arrays.stream(names).sorted(
                (s1,s2) -> s1.compareToIgnoreCase(s2)
        ).forEach(System.out::println);

        Comparator<Integer> comparator = Comparator.reverseOrder();
        Stream<Integer> integerStream = Stream.of(55, 23, -9, 8, 42);
        integerStream.sorted(
                comparator.reversed()
        ).forEach(System.out::println);

        Stream<String> stringStream1 = Stream.of("d", "cc", "bbb", "aaaa");
        // stringStream1.sorted().forEach(System.out::println);
        stringStream1.sorted(
                Comparator.comparingInt(String::length)
        ).forEach(System.out::println);

        System.out.println(" .............. ");
        Stream<String> stringStream2 = Stream.of("d", "a", "mm", "bb", "zzz", "www");
        Comparator<String> length = Comparator.comparingInt(String::length);
        stringStream2.sorted(length.thenComparing(String::compareTo)).forEach(
                System.out::println
        );

        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("Olive", "Middle East"));
        fruitList.add(new Fruit("Mango", "India"));
        fruitList.add(new Fruit("Cranberry", "North America"));
        fruitList.add(new Fruit("Watermelon", "Africa"));
        fruitList.add(new Fruit("Peach", "China"));
        fruitList.add(new Fruit("Fig", "Middle East"));
        fruitList.add(new Fruit("Blueberry", "North America"));

       /* fruitList.stream().sorted(
                Comparator.comparing(f -> f.countryOfOrigin,
                        Fruit::comp)).forEach(
                System.out::println
        );*/

        fruitList.stream().sorted(
                new Fruit().reversed())
        .forEach(System.out::println);

        Stream<String> stringStream3 = Stream.of("java", "python", "c", "c++");
        List<String> stringList = stringStream3.sorted().collect(Collectors.toList());
        System.out.println(stringList);

        Stream<String> stringStream4 = Stream.of("java", "python", "c",
                "c++", "java", "python");
        Set<String> set = stringStream4.collect(Collectors.toSet());
        System.out.println(set.size());

        Stream<String> stringStream5 = Stream.of("java", "python", "c",
                "c++", "java", "python");
        Set<String> set1 = stringStream5.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1);

        Person p1 = new Person(1010,"Sean");
        Person p3 = new Person(2843,"Lucy");
        Person p2 = new Person(1111,"Rob");

        Stream<Person> personStream = Stream.of(p1,p2,p3);
        Map<Integer,Person> personMap = personStream.collect(Collectors.toMap(p -> p.id, p -> p));
        System.out.println(personMap.size());

        Certifications c1 = new Certifications("S001", "OCA", 87);
        Certifications c2 = new Certifications("S002", "OCA", 82);
        Certifications c3 = new Certifications("S001", "OCP", 79);
        Certifications c4 = new Certifications("S002", "OCP", 89);
        Certifications c5 = new Certifications("S003", "OCA", 60);
        Certifications c6 = new Certifications("S004", "OCA", 88);

        Stream<Certifications> certificationsStream = Stream.of(c1,c2,c3,c4,c5,c6);
        /*Map<Boolean, List<Certifications>> booleanListMap =
                certificationsStream.collect(Collectors
                .partitioningBy(s->s.equals("OCA")));
        System.out.println(booleanListMap.get(true));*/

        Map<String, List<Certifications>> booleanListMap1 =
                certificationsStream.collect(Collectors
                        .groupingBy(Certifications::getTest));
        System.out.println(booleanListMap1.get("OCP"));

        String [] arr1 = {"Virat", "Rohit", "Shikhar", "Dhoni"};
        String [] arr2 = {"Bumrah", "Pandya", "Sami"};
        String [] arr3 = {};

        // won't print empty array --> why ?
        // is it because of flat map ?
        Stream<String[]> stringStream6 = Stream.of(arr1,arr2,arr3);
        stringStream6.flatMap(s -> Arrays.stream(s)).sorted().
                forEach(System.out::println);

        Stream<String> stringStream7 = Stream.of("ocp");
        stringStream7.flatMapToInt(s->s.chars()).forEach(i ->
                System.out.println((char)i));

        System.out.println("Printing ...");
        int res1 = 10;
        Stream<Integer> integerStream1 = Stream.iterate(res1, i -> i+1);
        System.out.println(integerStream1.anyMatch(i -> i>13));

        LongStream longStream = LongStream.empty();
        System.out.println(longStream.average());

        List<String> stringList1 = new ArrayList<>(Arrays.asList("Z","Y","X"));
        System.out.println(stringList1.stream().sorted().findFirst().get());
        System.out.println(stringList1.get(2));

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(3,"Three");

        // there is no stream method in map
        // System.out.println(map.stream().count());
        System.out.println(map.get(1));

        // it will always print the first number --> why ?
        System.out.println(Stream.of(10,0,-10,-100,200,1,-300).sorted().findAny().orElse(-1));

        Stream<Double> doubleStream1 = Stream.of(9.8,2.3,-3.0);
        // min() method will take the comparator as the argument to find the minimum
         System.out.println(doubleStream1.min(Double::compareTo));

        DoubleStream doubleStream2 = DoubleStream.of(9.8,2.3,-3.0);
        OptionalDouble optionalDouble = doubleStream2.min();
        System.out.println(optionalDouble);

        // Stream<Double> doubleStream3 = Stream.generate(() -> new Double("1.0"));
        // System.out.println(doubleStream3.sorted().findFirst());

        Stream<Double> doubleStream4 = Stream.generate(() -> new Double("1.0")).limit(10);
        System.out.println(doubleStream4.filter(d -> d>2)
        .allMatch(d -> d ==2));

        Stream<String> stringStream8 = Stream.of("a","as","an","and");
        Optional<String> first = stringStream8.findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        }

        List<Book> bookList = Arrays.asList(
                new Book ("Head First Java", "Kathy Sierra", 24.5),
                new Book ("OCP", "Udayan Khattry", 20.99),
                new Book ("OCA", "Udayan Khattry", 14.99)
        );

        bookList.stream().collect(Collectors.groupingBy(
                Book::getAuthor
        )).forEach((a,b) -> System.out.println(a));

        TrafficLight tl1 = new TrafficLight("GO", Color.GREEN);
        TrafficLight tl2 = new TrafficLight("Go Now!!" , Color.GREEN);
        TrafficLight tl3 = new TrafficLight("Read to stop" , Color.YELLOW);
        TrafficLight tl4 = new TrafficLight("Slow Down" , Color.YELLOW);
        TrafficLight tl5 = new TrafficLight("Stop", Color.RED);

        List<TrafficLight> trafficLights = Arrays.asList(tl1,tl2,tl3,tl4,tl5);

        Map<Color,List<String>> map1 = trafficLights.stream().
                collect(Collectors.groupingBy(TrafficLight::getColor ,
                        Collectors.mapping(TrafficLight::getMessage,Collectors.toList())));

        System.out.println(map1.get(Color.YELLOW));

        Message message = null;
        Optional<Message> optionalMessage = Optional.ofNullable(message);
        System.out.println(optionalMessage.isPresent() ? optionalMessage.get().getMsg() : new Message());

        List<Integer> integerList = Arrays.asList(-80,100,-40,25,200);
        Predicate<Integer> predicate = num -> {
            int ctr = 1;
            boolean result = num >0;
            System.out.print(ctr++ + ".");
            return result;
        };
        integerList.stream().filter(predicate).count();
        // integerList.stream().filter(predicate).sorted();
        // integerList.stream().filter(predicate).findFirst();

        List<Integer> integerList1 = Arrays.asList(10,20,8);

        System.out.println("Same output");

        System.out.println(integerList1.stream().max(
                Comparator.comparing(a -> a)).get());

        System.out.println(integerList1.stream().max(Integer::compareTo).get());
        System.out.println(integerList1.stream().max(Integer::max).get());

        List<String> stringList2 = Arrays.asList("1st","2nd","3rd","4th");
        System.out.println(stringList2.stream().filter(
                s->s.endsWith("d")).reduce((s1,s2) -> s1 + s2));

        List<Boolean> booleans = Arrays.asList(false,
                new Boolean(null), new Boolean("1"),
                new Boolean("0"));

        BinaryOperator<Boolean> operator = (b1,b2) -> b1 || b2;
        System.out.println(booleans.stream().reduce(false,operator));

        long seed = 10;
        Stream<Long> longStream1 = Stream.iterate(seed, i -> i+2).limit(2);
        LongFunction<LongUnaryOperator> longFunction = m->n-> n/m;
        longStream1.mapToLong(i->i).map(longFunction.apply(2)).forEach(
                System.out::println
        );

        List<MyString> myList = new ArrayList<>();
        myList.add(new MyString("Y"));
        myList.add(new MyString("E"));
        myList.add(new MyString("S"));

        myList.stream().forEach(System.out::println);
    }
}
