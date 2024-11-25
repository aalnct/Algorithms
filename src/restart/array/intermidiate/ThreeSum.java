package restart.array.intermidiate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int [] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> r : result) {
            System.out.println(r);
        }
    }

    static List<List<Integer>> threeSum (int [] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i=0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            int target = -nums[i]; // b + c = -a

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // skipping duplicate
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right+1]) {
                        right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
