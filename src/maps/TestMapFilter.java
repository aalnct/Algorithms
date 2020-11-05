package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by AmitAgarwal on 3/21/19.
 */
public class TestMapFilter {

    public static void main(String [] args){
        String result;
        Map<Integer,String> hosting = new HashMap<>();
        hosting.put(1,"google.com");
        hosting.put(2,"heroku.com");
        hosting.put(3,"amazon.com");



        result = hosting.entrySet().stream()
                .filter(map -> "amazon.com".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("with Java 8 :: " + result);


        //filter more values
        result = hosting.entrySet().stream().filter(x -> {
            return !x.getValue().contains("amazon") && !x.getValue().contains("google");
        }).map(map -> map.getValue()).collect(Collectors.joining());

        System.out.println("More filters ::" +result);

    }

    //Predicate function




}
