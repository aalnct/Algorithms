package ds.dequeue;

import java.util.*;

/**
 * Created by AmitAgarwal on 3/19/19.
 */
public class ScannerLearn {

    public static void main(String [] args){
        int key;
        List<Integer> keyList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque();
        HashMap<Integer,Integer> map = new HashMap<>();

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);
        deque.add(7);

        map.put(1,100);
        map.put(2,200);
        map.put(3,300);
        map.put(4,400);
        map.put(5,500);
        map.put(6,600);
        map.put(7,700);

        if(map.containsKey(deque)){
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                key = entry.getKey();
                keyList.add(key);
            }
            keyList.stream().forEach(System.out::println);

        }
    }
}
