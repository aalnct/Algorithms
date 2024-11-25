package OAGoogle.array;

import java.util.HashMap;
import java.util.Map;

public class RepeatedElements {

    public static void main(String[] args) {
        int [] array = {2,3,4,8,8};
        System.out.println(repeatedElements(array));
    }

    static int repeatedElements (int [] array) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int a : array) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                return a;
            }
        }
        return -1;
    }
}
