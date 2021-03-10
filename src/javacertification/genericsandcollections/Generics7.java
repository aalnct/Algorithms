package javacertification.genericsandcollections;

import java.util.*;

public class Generics7 {
    public static void main(String[] args) {
        Map<TrafficLight, String> map = new HashMap<>();
        map.put(TrafficLight.GREEN, "Green");
        map.put(TrafficLight.RED , "Red");
        map.put(TrafficLight.YELLOW, "Yellow");

        map.keySet().stream().forEach(System.out::println);

        Map<TrafficLight, String> treeMap = new TreeMap<>();
        treeMap.put(TrafficLight.GREEN, "GO");
        treeMap.put(TrafficLight.RED ,  "STOP");
        treeMap.put(TrafficLight.YELLOW, "Stop in 3 seconds");
        treeMap.put(TrafficLight.YELLOW, "Ready to Stop");

        treeMap.entrySet().stream().forEach(System.out::println);

        Map<Integer, String> linkedHashMap = new HashMap<>();
        linkedHashMap.put(null, "Zero");
        linkedHashMap.put(1, "one");
        linkedHashMap.entrySet().stream().forEach(System.out::println);

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(25, "Mumbai");
        navigableMap.put(32, "Delhi");
        navigableMap.put(11, "SriNagar");
        navigableMap.put(39, "india");

        navigableMap.headMap(25,false).entrySet().stream().forEach(
                System.out::println
        );

        System.out.println("......................");

        navigableMap.headMap(25).entrySet().stream().forEach(
                System.out::println
        );

        navigableMap.tailMap(25).entrySet().stream().forEach(
                System.out::println
        );

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(100);
        deque.add(200);

        deque.addFirst(300);
        deque.addLast(400);
        deque.remove(200);

        System.out.println(deque.getFirst());

        Deque<Boolean> booleanDeque = new ArrayDeque<>();
        booleanDeque.push(new Boolean("abc"));
        booleanDeque.push(new Boolean("true"));
        booleanDeque.push(new Boolean("FALSE"));
        booleanDeque.push(true);

        System.out.println(booleanDeque.pop() + " : "+ booleanDeque.peek() + " : " + booleanDeque.size());
        // true:true:3

        Set<Character> characterSet = new TreeSet<>(Arrays.asList('a','b','c','A','a','c'));
        characterSet.stream().forEach(System.out::print);

        // Set<String> stringSet = new TreeSet<>(Arrays.asList(null,null,null));
        // long count = stringSet.stream().count();
        // System.out.println(count);

        System.out.println( ".............." );
        Set<String> hashSet = new HashSet<>(Arrays.asList(null,null,null));
        long count1 = hashSet.stream().count();
        System.out.println(count1);


        NavigableSet<String> navigableSet = new TreeSet<>(Arrays.asList("red", "green", "blue", "gray"));
        System.out.println(navigableSet.ceiling("gray"));
        System.out.println(navigableSet.floor("gray"));
        System.out.println(navigableSet.higher("gray"));
        System.out.println(navigableSet.lower("gray"));

        List<String> strlist = new LinkedList<>();
        strlist.add("ONE");
        strlist.add("TWO");
        strlist.remove(1);

        strlist.stream().forEach(System.out::print);

        Queue<String> queue = new LinkedList<>();
        queue.add("ONE"); // head of the queue
        queue.add("TWO");

        queue.remove();

        queue.stream().forEach(System.out::print);

        Deque<Character> characterDeque = new ArrayDeque<>();
        characterDeque.add('A');
        characterDeque.add('B');
        characterDeque.remove();
        characterDeque.add('C');
        characterDeque.remove();

        characterDeque.stream().forEach(System.out::print);

        // List<String> list = Arrays.asList("oca", null, "ocp", "java", "null");
        // Deque<String> deque1 = new ArrayDeque<>(list);

        // System.out.println(deque1.size());

        Deque<Character> charD = new ArrayDeque<>();
        charD.add('A');
        charD.remove();
       // charD.remove(); // no such element exception, since deque is already empty with last remove () operation

        System.out.println(charD);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>");

        List<Integer> integerList = Arrays.asList(0,2,4,6,8);
        integerList.replaceAll(i -> i+1);

        integerList.stream().forEach(System.out::print);

        System.out.println("");
        System.out.println("");

        List<Integer> integerList1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(".... Stream filter operations");
        // this works fine, since this is just a filter
        integerList1.stream().filter(i->i%2 == 1).forEach(System.out::print);

        System.out.println("Normal remove if operations.....");
        // this is updating the list itself which we cannot do while iterating the list
        // so unsupported operation exception
       // integerList1.removeIf(i -> i%2==1);
        integerList1.stream().forEach(System.out::print);

        List genericList = new ArrayList<Integer>();
        genericList.add(1);
        genericList.add(2);
        genericList.add("3");

        // below operation cannot be applied to object list
        // genericList.removeIf(i->i%2==1);
    }
}
