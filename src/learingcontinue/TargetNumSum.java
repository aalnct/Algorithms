package learingcontinue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetNumSum {

    public static void main(String[] args) {
        int [] array = new int[] {3,2,4};
        int target = 11;
        int[] result = targetSumNumbers(array,target);
        System.out.println(Arrays.toString(result));

        result = twoSum(array,target);
        System.out.println(Arrays.toString(result));
    }

    protected static int[] targetSumNumbers(int [] array, int target) {
        int len = array.length;
        int left = 0;
        int right = len-1;
        int [] indices = new int[2];

        while (left < right) {
            int sum = array[left] + array[right];
            if (sum == target) {
                indices[0] = left;
                indices[1] = right;
                return indices;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    private static int[] twoSum(int[] array, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < array.length; i++) {
            int result = target - array[i];
            if (map.containsKey(result)) {
                return new int[] {map.get(result), i};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[0];
    }
}
