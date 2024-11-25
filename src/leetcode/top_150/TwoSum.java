package leetcode.top_150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    private static int [] twoSum (int [] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int [] {map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int [0];
    }
}
