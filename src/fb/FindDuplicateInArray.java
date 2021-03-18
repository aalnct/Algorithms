package fb;

import java.util.HashMap;
import java.util.Map;

public class FindDuplicateInArray {

    public static void main(String[] args) {
        int [] array = new int [] {1, 2, 3, 4, 4 };
        int i  = returnDuplicate(array);
        System.out.println(i);
    }

    static int returnDuplicate (int [] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i] , map.get(array[i]) + 1);
            } else {
                map.put(array[i] ,  1);
            }

            if (map.get(array[i]) > 1) {
                return array[i];
            }
        }
        return 0; // if reaches here, that means there is no duplicate.
    }
}
