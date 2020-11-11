package threading.streamapi;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamString {
    public static void main(String[] args) {
        String [] string = new String[]{"Adam","Daniel","Martha","Kevin","Joe", "Susan", "Brad","Adam","Daniel"};

        Stream.of(string).forEach(System.out::println);
        System.out.println("*********");
        Stream.of(string).sorted().forEach(System.out::println);
        System.out.println("*********");
        Stream.of(string).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("*********");
        Stream.of(string).sorted().distinct().forEach(System.out::println);
    }
}
