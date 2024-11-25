package restart.array.basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumArray {

    public static void main(String[] args) {
        int [] array = {2,7,11,13};
        int target = 9;

        System.out.println(Arrays.toString(twoSumArray(array,target)));
    }

    static int [] twoSumArray (int [] array, int target) {
        Map<Integer,Integer> twoSum = new HashMap<>();

        for (int j : array) {
            twoSum.put(j, 1);
        }

        for (int i=0; i < array.length; i++) {
            int result = target - array[i];

            if (twoSum.containsKey(result)) {
                return new int [] {twoSum.get(result),i}; // returns the index
            }
        }
        return new int[] {};
    }
}
