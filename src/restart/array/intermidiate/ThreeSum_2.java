package restart.array.intermidiate;

import java.util.*;

public class ThreeSum_2 {

    public static void main(String[] args) {
        int nums [] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    /**
     * Using HashSet Approach
     * @param nums
     * @return
     */
    static List<List<Integer>> threeSum (int [] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        // Instead of taking list and then manually implementing
        // duplicate check, I have take set so that it will internally remove the duplicate value
        Set<List<Integer>> result = new HashSet<>();

        for (int i=0; i < nums.length-1; i++) {
            int left = i + 1;
            int right = nums.length-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
