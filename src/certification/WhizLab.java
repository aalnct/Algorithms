package certification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by AmitAgarwal on 1/14/20.
 */
public abstract class WhizLab {

    private void run(){
        System.out.println("A");
    }

    public static void main(String [] args){
        Map<Integer, String> map = new TreeMap<>();

        map.put(1, "One");
        map.put(2, "two");
        map.put(3, "three");


        map.replace(1, "1", null);
        map.replace(3, null);

        System.out.println(map.values());

        List<Integer> ints = new ArrayList<>();
        //IntStream.range(0,9).forEach(ints::add);
        IntStream.rangeClosed(0,10).forEach(ints::add);

        for (Integer print: ints) {
            System.out.println(print);
        }
    }
}