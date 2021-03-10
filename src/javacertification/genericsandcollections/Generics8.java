package javacertification.genericsandcollections;

import java.util.*;
import java.util.stream.Collectors;

public class Generics8 {
    public static void main(String[] args) {
        Set<Employees> employees = new TreeSet<>();
        employees.add(new Employees("Udayan", 31));
        employees.add(new Employees("Neha" , 23));
        employees.add(new Employees("Hou", 42));
        employees.add(new Employees("Smita", 29));

        employees.stream().forEach(System.out::print);

        System.out.println("");

        List<Names> name = Arrays.asList(new Names("Peter", "Lee"), new Names("John", "Smith"),
                new Names("bonita", "smith"));

       // Collections.sort(name, Comparator.comparing(Names::getFirst));

        Collections.sort(name, (o1, o2) -> o1.getFirst().compareToIgnoreCase(o2.getFirst()));

        name.stream().forEach(System.out::print);

        System.out.println( "-------------------------------------------" );

        String [] arr = {"**" , "***", "*", "*****", "****"};
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        // Arrays.sort(arr, (s1,s2) -> s1.length() - s2.length());
            // above line can be replaced with below line
        // Arrays.sort(arr, Comparator.comparingInt(String::length));

        Arrays.stream(arr).collect(Collectors.toList()).stream().forEach(System.out::println);

        List<String> strList = Arrays.asList("James", "Diana", "Anna");

        Collections.sort(strList, (o1, o2) -> o1.compareToIgnoreCase(o2));

        //Collections.sort(strList);

        strList.stream().forEach(System.out::print);
    }
}
