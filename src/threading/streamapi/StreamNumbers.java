package threading.streamapi;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamNumbers {

    public static void main(String[] args) {
        int [] array = new int [] {1,5,3, -2,9,12};
        int sum = 0;

        for (int i=0;i < array.length;i++) {
            sum = sum + array[i];
            System.out.println(array[i]);
        }
        System.out.println(sum);

        System.out.println("Java 8 Stream APIs");

        // lambda expressions
        // :: operator or method references
        Arrays.stream(array).forEach(System.out::println); // convert to a stream and then perform operations
        sum = Arrays.stream(array).sum();
        System.out.println("Stream Sum ::" + sum);

        System.out.println(IntStream.range(0,10).sum());

        System.out.println("****");
        IntStream.range(0,20).filter(x -> x>10).forEach(System.out::println);
    }
}
