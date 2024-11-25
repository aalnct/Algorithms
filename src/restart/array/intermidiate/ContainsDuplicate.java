package restart.array.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int [] array = {1,2,2,3};
        System.out.println(containsDuplicate(array));
    }

    static boolean containsDuplicate (int [] array) {
        if (array == null || array.length == 0) {
            return false; // no duplicate
        }

        Map<Integer,Integer> duplicateMap = new HashMap<>();

        for (int i=0; i < array.length; i++) {
            if (!duplicateMap.containsKey(array[i])) {
                duplicateMap.put(array[i], 1);
            } else {
                duplicateMap.put(array[i] , duplicateMap.get(array[i]) + 1);
            }
        }

        for (int i=0; i < array.length; i++) {
            if (duplicateMap.get(array[i]) > 1) {
                return true;
            }
        }
        return false;
    }
}
