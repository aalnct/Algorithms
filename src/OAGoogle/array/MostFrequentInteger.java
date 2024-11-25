package OAGoogle.array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentInteger {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,4,4,4,4,};
        System.out.println(mostFrequent(nums));
    }

    static int mostFrequent (int [] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array is Empty");
        }

        Map<Integer,Integer> frequencyMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            frequencyMap.put(nums[i],
                    frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        int count = 0;
        int newCount = 0;
        int maxValue = 0;
        for (Map.Entry<Integer,Integer> entry : frequencyMap.entrySet()) {
            count = Math.max(count,entry.getValue());
            if (count > newCount) {
                newCount = count;
                maxValue = entry.getKey();
            }
        }

        return maxValue;
    }
}
