package javacertification.genericsandcollections;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Generics9 {
    public static void main(String[] args) {
        List<Points> points = new ArrayList<>();
        points.add(new Points(4,5));
        points.add(new Points(6,7));
        points.add(new Points(2,2));

        /*Collections.sort(points, Comparator.comparingInt(o -> o.x));
        points.stream().forEach(System.out::print);*/

        Collections.sort(points, (o1,o2) -> o2.x - o2.x);
        points.stream().forEach(System.out::print);

        System.out.println(" ");

        List<String> list = Arrays.asList("M", "R", "A", "P");
        Collections.sort(list,null);

        list.stream().forEach(s -> System.out.println(s));

        String[] str = {"A5", "B4", "C3", "D2", "E1"};
        // will sort in descending order
        Arrays.sort(str, Comparator.comparing(s -> s.substring(1)));

        Arrays.stream(str).forEach(s -> System.out.println(s));

        List<String> emails = Arrays.asList("udayan@outlook.com", "sachin@outlook.com",
                "sachin@gmail.com", "udayan@gmail.com");

        Collections.sort(emails, Comparator.comparing(str1 -> str1.substring(
                str1.indexOf('@') +1)));

        emails.stream().forEach(s -> System.out.println(s));

        List<String> specialCharacter = Arrays.asList("#####", "#", "##", "####", "###");
        Comparator<String> comparator = Comparator.comparing(s -> s);
        Collections.sort(specialCharacter, comparator.reversed());

        specialCharacter.stream().forEach(System.out::println);

        System.out.println(" ");

        List<Person> personList = Arrays.asList(
                new Person("Tom" , "Riddle"),
                new Person("Tom" , "Hanks"),
                new Person("Yusuf" , "Pathan")
        );

        personList.stream().sorted(Comparator.comparing(Person::getFirstName)
        .reversed().thenComparing(Person::getLastName)).forEach(
                System.out::println
        );

        Student1 student1 = new Student1("John", "OCA");
        Student1 student2 = new Student1("Jack", "OCP");
        Student1 student3 = new Student1("Rob", "OCP");

        List<Student1> studentList = Arrays.asList(student1,student2,student3);
        studentList.sort(new Student1());
        studentList.stream().forEach(student11 -> System.out.println(student11));

        Deque<Integer> deque = new ArrayDeque<>();
        int i = 2000;
        deque.add(1000);
        deque.add(i);
        deque.add(3000);

        deque.forEach(System.out::println);
        deque.forEach(s -> System.out.println(s));

        List<Employee1> employeeList = Arrays.asList(
                new Employee1("Jack", 10000),
                new Employee1("Lucy" ,  12000)
        );

        employeeList.stream().forEach(e -> e.setSalary(e.getSalary() + (e.getSalary()*.2)));
        employeeList.stream().forEach(System.out::println);

        String [] cities = new String[] {"Seoul", "Tokyo", "Paris", "London",
                "Hong Kong", "Singapore"};


        /**
         * expression for comprarission here is basically
         * we are comparing in reverse order, so updated code from
         * {Line 95}
         */
        /*Arrays.stream(cities).sorted((s1,s2) -> s2.compareTo(s1))
                .forEach(System.out::println);*/

        Arrays.stream(cities).sorted(Comparator.reverseOrder())
        .forEach(System.out::println);

        List<String> alpha = Arrays.asList(
                "A", "A", "b", "B", "c", "c"
        );

        alpha.stream().distinct().forEach(
                System.out::println
        );

        List<Employee1> list1 = Arrays.asList(
          new Employee1("Jack", 10000),
          new Employee1("Lucy", 12000)
        );

        list1.stream().filter(x -> x.getSalary() > 10000)
                .map(m -> m.getName())
                .forEach(System.out::println);

        // start inclusive and end exclusive
        IntStream.range(1,10).forEach(System.out::println);

        /**
         * start from 0, then increment with 2
         * and limit for number digits upto 4
         */
        LongStream.iterate(0,j->j+2).limit(4).
                forEach(System.out::print);

        System.out.println(" ");

        IntStream.iterate(1, k-> k+1).limit(11)
                .filter(k -> k%2 !=0).forEach(
                        System.out::print
        );

        System.out.println(" ");

        List<StringBuilder> builders = new ArrayList<>();
        builders.add(new StringBuilder("abc"));
        builders.add(new StringBuilder("xyz"));

        builders.stream().map(x -> x.reverse())
                .forEach(System.out::println);

        List<Employee1> l1 = Arrays.asList(
                new Employee1("Jack", 10000),
                new Employee1("Lucy", 12000)
        );

        l1.stream().peek(e->e.setSalary(e.getSalary() +1000))
                .forEach(System.out::println);

        System.out.println(IntStream.range(10,1).count());

        IntStream stream = "OCP".chars();

        // stream.forEach(c -> System.out.println((char)c));
        System.out.println(stream.count());

        List<String> l2 = Arrays.asList("M", "R", "A", "P");
        Collections.sort(l2, null);
        l2.stream().forEach(System.out::print);

        System.out.println(" ");

        /**
         * implementation of range method is that, first variable
         * should be less than second variable, else it will return the range as empty
         */
        System.out.println(IntStream.range(-10,-10).count());
        System.out.println(IntStream.rangeClosed(-10,-10).count());

        String string = "North East West South";
        string.chars().filter(Generics9::isDirections)
                .forEach(System.out::print);

        string.chars().filter(Generics9::isDirections)
                .forEach(c -> System.out.print((char)c));

    }

    private static boolean isDirections (int ch) {
        switch (ch) {
            case 'N':
            case 'E':
            case 'W':
            case 'S':
                return true;
        }
        return false;
    }
}
