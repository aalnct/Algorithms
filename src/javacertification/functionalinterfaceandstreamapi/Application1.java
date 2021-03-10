package javacertification.functionalinterfaceandstreamapi;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

class Counter {
    static int count = 1;
}

public class Application1 {
    private static void print (Predicate<Integer> predicate) {
        for (int i=1;i<=10;i++) {
            if (predicate.test(i)) {
                System.out.print(i);
            }
        }
    }

    private static void print1 (String [] arr, Predicate<String> predicate) {
        for (String str : arr) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }
    }

    public static void main(String[] args) {

        Consumer<String> c1 = str -> {
            System.out.println(
                    // it will fist reverse the string,
                    // then it will apply substring
                    new StringBuilder(str).reverse().substring(2)
            );
        };
        c1.accept("!yppahnu");

        Consumer<Integer> add = i2 -> Counter.count +=i2;
        Consumer<Integer> consumer =  System.out::print;
        Integer i1 = 5;
        add.andThen(consumer).accept(10);

        System.out.println();

        String arr [] = {"*", "**", "***", "****", "*****", "******"};
        Predicate<String> p1 = s2 -> s2.length() > 3;
        print1(arr,p1);

        print(i-> i%2 !=0);

        Function<char[], String> function = String::new;
        String s = function.apply(new char[] {'j','a','v','a'});
        System.out.println(s);

        Function<Integer,Integer> f = x-> x+10;
        Function<Integer, Integer> g = y -> y*y;

        Function<Integer,Integer> fog = f.andThen(g);
        System.out.println(fog.apply(10));

        Function<String,Integer> f1 = Integer::new;
        Function<String,String> f2 = s1-> new StringBuilder(s1).reverse().toString();
        // below line will first compose the function
        // and then apply
        System.out.println(f1.compose(f2).apply("12345"));


        Supplier<StringBuilder> supplier = () -> new StringBuilder(" olleh")
                .reverse().append("!dlrow").reverse();

        // supplier.get().reverse();

        System.out.println(supplier.get());
        System.out.println(supplier.get().reverse());

        Supplier<Date> date = Date::new;
        Date date1 = date.get();
        System.out.println(date1);

        Supplier date2 = Date::new;
        // required date find object
        // Date date3 = date2.get();
        System.out.println(date1);

        // function takes 2 arguments
        // Function<Date> fDate = Date::new;
        check (Document::new);
        check(RFP::new);


        String [] array = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};

        Predicate<String> pd1 = s3 -> s3.startsWith("A");
        Predicate<String> pd2 = s3 -> s3.startsWith("a");
        Predicate<String> pd3 = s3 -> s3.length() >= 3;

        processStringArray (array ,pd1.or(pd2).and(pd3));
        System.out.println("Second ...");
        processStringArray(array, p->p.length()<10);

        List<Employee> employees = Arrays.asList(
                new Employee("Jack", 8000),
                new Employee("Lucy", 12000)
        );

        updateSalary (employees, d -> d < 10000);
        employees.forEach(System.out::println);

        // in rangeClosed (startInclusive, endInclusive)
        LongStream.rangeClosed(51,75).filter(l -> l%5 ==0)
                .forEach(l -> System.out.println(l + " "));

        // IntConsumer intConsumer = i4-> i4*i4*i4;
        int result = IntStream.range(1,5).sum();
        System.out.println(result);

        BiFunction <Double, Double, Integer> comp = Double::compareTo;
        System.out.println(comp.apply(10.01, 11.99));

        BiPredicate<String , String> predicate = String::equalsIgnoreCase;
        System.out.println(predicate.test("JaVa", "java"));

        NavigableMap <Integer, String> map = new TreeMap<>();
        BiConsumer<Integer, String> biConsumer = map::putIfAbsent;

        /**
         * Since for key 1 - value is null, it will replace it with new value
         *
         *  If the specified key is not already associated with a value (or is mapped
         *      * to {@code null}) associates it with the given value and returns
         *      * {@code null}, else returns the current value.
         */
        biConsumer.accept(1,null);
        biConsumer.accept(2,"two");
        biConsumer.accept(1,"ONE");
        biConsumer.accept(2,"TWO");

        System.out.println(map);

        Map<Integer,Integer> map1 = new LinkedHashMap<>();
        map1.put(1,10);
        map1.put(2,20);

        BiConsumer<Integer,Integer> biConsumer1 = (k,v) -> {
            System.out.println(k + ":" + v);
        };

        BiFunction<Integer,Integer,Integer> function1 = (k,v) -> {
            System.out.println(k + ":" + v);
            return null;
        };
        map1.forEach(biConsumer1);

        String [] arr1 = {"A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab"};
        BiPredicate<String, String> biPredicate = String::startsWith;

        System.out.println( " ***** ");

        for (String s2 : arr1) {
            if (biPredicate.negate().test(s2, "A")) {
                System.out.println(s2);
            }
        }

        BiFunction<String,String, String> func = String::concat;
        System.out.println(func.apply("James", "Gosling"));

        BiFunction<String,String,String> function2 = (s1,s2) -> s2.concat(s1).trim();
        System.out.println(function2.apply(" CD", " AB"));

        BiPredicate<String,String> bb = String::contains;
        BiFunction <String,String,Boolean> bf = (str1,str2) -> bb.test(str1,str2) ? true : false;

        System.out.println(bf.apply("Tomato", "at"));

        BiFunction<String,String,String> bi2 = (str1,str2) -> (str1 + str2);
        BiPredicate<String,String> biPredicate1 = (str1,str2) -> (bi2.apply(
                str1,str2).length() > 10);

        String [] strArray = {"vention", "historic", "sident", "sentation", "vious"};

        for (String s1 : strArray) {
            if (biPredicate1.test("pre",s1)) {
                System.out.println(bi2.apply("pre",s1));
            }
        }
        DoubleFunction <DoubleUnaryOperator> func1 = m -> n -> m+n;
        System.out.println(func1.apply(11).applyAsDouble(24));
    }



    private static void updateSalary (List<Employee> list, DoublePredicate predicate) {
        for (Employee e: list) {
            if (predicate.negate().test(e.getSalary())) {
                e.setSalary(e.getSalary() + 2000);
            }
        }
    }

    private static void processStringArray(String[] array, Predicate<String> predicate) {
        for (String str : array) {
            if (predicate.test(str)) {
                System.out.println(str);
            }
        }
    }


    private static void check (Supplier<? extends Document> supplier) {
        supplier.get().printAuthor();
    }
}

class Document {
    void printAuthor () {
        System.out.println("Document-Author");
    }
}

class RFP extends Document {
    @Override
    void printAuthor() {
        System.out.println("RFP-Author");
    }
}
