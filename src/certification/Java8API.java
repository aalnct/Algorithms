package certification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by AmitAgarwal on 1/26/20.
 */
public class Java8API {

    public static void main(String [] args){
        List<String> list = new ArrayList<>();
        list.add("Amit");
        list.add("Naresh");
        list.add("Sachin");
        //list.add(null);

        /**
         * to just print a list
         */
        list.forEach(System.out::println);


        /**
         * Map list to upper case
         */

        list.stream().map(String::toUpperCase).forEach(System.out::println);

        /**
         * using a filter with Map
         */

        list.stream().map(String::toUpperCase).filter(l -> list.contains("Amit")).forEach(System.out::println);


        List<String> lines = Arrays.asList("Spring", "Nodejs", "AngularJs");
        List<String> result = lines.stream().filter(line -> !"AngularJs".equalsIgnoreCase(line)).collect(Collectors.toList());

        result.forEach(System.out::println);


    }

}
