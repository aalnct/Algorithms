package java8api.functionalInterfaces;

import java.util.function.Consumer;

public class ConsumerFunctionInterface {
    public static void main(String[] args) {
        Consumer<String> consumer1 = (s -> System.out.println(s.toUpperCase()));
        consumer1.accept("java");
    }

}
