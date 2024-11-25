package OAGoogle.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = _3Sum(nums);

        for (List<Integer> r : result) {
            for (int r1 : r) {
                System.out.println(r1);
            }
        }
    }

    static List<List<Integer>> _3Sum (int [] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == 0) {
                    if (!result.contains(Arrays.asList(nums[i], nums[left], nums[right]))) {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return result;
    }
}
