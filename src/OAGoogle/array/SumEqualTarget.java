package OAGoogle.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumEqualTarget {

    public static void main(String[] args) {
        int [] nums = {1,9,1};
        int target = 10;

        sumEqualsTarget(nums,target).forEach(System.out::println);
    }

    static List<Integer> sumEqualsTarget (int [] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> targetMap = new HashMap<>();

        for(int i=0; i < nums.length; i++) {
            targetMap.put(nums[i], i);
        }

        for (int i=0; i < nums.length; i++) {
            int result = target - nums[i];
            if (targetMap.containsKey(result)) {
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                    list.add(result);
                }

            }
        }

        return list;
    }

}
