package neetcode150.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int nums [] = {3,4,5,6};
        int target = 7;

        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    static int [] twoSum (int [] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int [] {map.get(diff), i};
            }
            map.put(nums[i],i);
        }
        return new int [] {};
    }
}