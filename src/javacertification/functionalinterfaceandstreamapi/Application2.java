package javacertification.functionalinterfaceandstreamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

interface StringConsumer extends Consumer<String> {
    @Override
    default void accept (String s) {
        System.out.println(s.toUpperCase());
    }
}

public class Application2 {
    public static void main(String[] args) {
        int ref = 10;
        List<Integer> integerList = new ArrayList<>();
        integerList.stream().anyMatch(i ->{
            System.out.println("HELLO");
            return i > ref;
        });

        Optional<String> optional = Stream.of("red", "green", "blue", "yellow")
                .sorted().findFirst();
        System.out.println(" :: " + optional.get());

        /*Optional<Integer> optionalInteger = Optional.of(null);
        System.out.println("....." + optionalInteger);*/

        Optional<Integer> integerOptional = Stream.of(10).findFirst();
        System.out.println(integerOptional);

        Optional<Integer> integerOptional1 = Optional.ofNullable(null);
        System.out.println(integerOptional1);

        Stream<Number> stream11 = Stream.of();
        Optional<Number> optionalNumber = stream11.findFirst();
        System.out.println(optionalNumber.orElse(-1));


        System.out.println("Optional null testing ....");

        // Optional<Integer> optional1 = Optional.of(null); // this will throw null pointer





        LongFunction<LongUnaryOperator> function = a -> b -> b-a;
        System.out.println(cal (function.apply(100),50));

        List<String> list = Arrays.asList("north", "east", "west", "south");
        list.replaceAll(s -> s.substring(0,1).toUpperCase().concat(s.substring(1)));

        list.forEach(System.out::print);

        System.out.println("");

        List<Integer> list1 = Arrays.asList(10,100,1000);
        list1.replaceAll(i -> -i++);
        list1.forEach(System.out::print);

        System.out.println(" ");

        final String password = "Oracle";
        UnaryOperator<String> opr1 = s -> s.replace('a','@');
        UnaryOperator<String> opr2 = s -> password.concat(s);
        System.out.println("Password :" + opr1.apply(opr2.apply("!")));

        UnaryOperator<String> opr3 = s -> s.toUpperCase();
        System.out.println(opr3.apply("Hello"));

        StringConsumer stringConsumer = new StringConsumer() {
            @Override
            public void accept(String s) {
                System.out.println("" + s.toLowerCase());
            }
        };

        List<String> list2 = Arrays.asList("Dr", "Mr", "Miss", "Mrs");
        list2.forEach(stringConsumer);

        // StringConsumer strConsumer = s9 -> System.out.println(s9.toLowerCase());

        List<Integer> list3 = Arrays.asList(2,3,4);
        UnaryOperator<Integer> opr4 = s -> s*s*s;
        list3.replaceAll(opr4);
        list3.forEach(System.out::println);

        String text = "Aa aA aB Ba aC Ca";
        ToIntFunction<String> func = text::indexOf;
        System.out.println(func.applyAsInt("a"));

        // BiFunction<Integer,Integer,Character> compFunc = (i,j) -> i+j;

        // this needs to be applied as integer
        BiFunction<Integer,Integer,Object> compFunc = (i,j) -> i+j;
        System.out.println(compFunc.apply(0,65));

        Stream<StringBuilder> stream = Stream.of(new StringBuilder("test"));
        stream.map(s -> s.reverse()).forEach(System.out::println);

        Stream.of(true, false, true).map(b -> b.toString()
                .toUpperCase()).peek(System.out::println).count();

        List<String> list4 = new ArrayList<>();

        System.out.println(list4.stream().anyMatch(s -> s.length() > 0));
        System.out.println(list4.stream().allMatch(s -> s.length() > 0));
        System.out.println(list4.stream().noneMatch(s -> s.length() > 0));

        
    }

    private static long cal(LongUnaryOperator apply, long val) {
        return apply.applyAsLong(val);
    }
}
