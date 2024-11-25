package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6};
        int target = 7;

        List<int[]> find = findPairs(array,target);

        for (int [] pair : find) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    static List<int []> findPairs (int [] array, int target) {
        List<int[]> pairs = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int a :array) {
            int complement = target - a;
            if (map.containsKey(complement)) {
                pairs.add(new int [] {complement,a});
            }
            map.put(a,1);
        }
        return pairs;
    }
}
