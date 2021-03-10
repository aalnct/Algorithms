package javacertification.genericsandcollections;

import java.util.*;
import java.util.stream.IntStream;

public class IncorrectQuestions<T> {
    T [] obj;

    public IncorrectQuestions () {
        // type parameter cannot be instantiated directly
        // obj = new T[100];
    }

    public static void main(String[] args) {
        // tree set requires to provide either comparable or comparator.
        // if we don't provide comparator explicitly, then for natural ordering
        // class should implement comparable interface

        Set<Student> set = new TreeSet<>();
        set.add(new Student("James", 20));
        set.add(new Student("James", 20));
        set.add(new Student("James", 22));

        System.out.println(set.size());

        System.out.println("");
        // tree map is the sorted map on the basis of natural ordering of key
        // if comparator is not provided
        Map<TrafficLight, String> map = new TreeMap<>();
        map.put(TrafficLight.YELLOW, "Ready to Stop");
        map.put(TrafficLight.RED, "Stop");
        map.put(TrafficLight.GREEN, "GO");

        map.entrySet().stream().forEach(
                (k) -> System.out.println(k.getValue()));

        System.out.println("");

        // raw usage of parametrized class
        List l1 = new ArrayList<String>();
        l1.add("1");
        l1.add("2");
        l1.forEach(s-> System.out.print(s));

        System.out.println();

        // with super --> issue is when we read the object, since
        // type of read object is string and type of write object is
        // String and its subclasses (no subclasses for string, since it is final)
        List<? super String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.stream().forEach(System.out::println);

        System.out.println("");

        /*for (String str : list) { // compile time issue
            System.out.print(str);
        }*/
        for (Object str : list) {
            System.out.print(str);
        }

        add(10,20);
    }

    private static final <X extends Integer, Y extends Integer> void add (X x, Y y) {
         // System.out.println(x+y); ? not sure about this
    }
}
