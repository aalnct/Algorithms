package restart.array.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {


    public static void main(String[] args) {
        int [] nums = {10,5,2,7,1,9};
        int k = 15;
        System.out.println(longestSubArray(nums, k));
    }

    static int longestSubArray (int [] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int cumulativeSum = 0;
        int maxLength = 0;

        for (int i=0; i < nums.length; i++) {
            cumulativeSum += nums[i];

            if (cumulativeSum == k) {
                maxLength = i+1;
            }

            if (map.containsKey(cumulativeSum - k)) { // if this is true that means there is a
                                                     // number exists and we need to find its index
                maxLength = Math.max(maxLength,
                        i - map.get(cumulativeSum - k));

            }

            if (!map.containsKey(cumulativeSum)) {
                map.put(cumulativeSum,i);
            }
        }
        return maxLength;
    }

}
