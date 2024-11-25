package restart.array.basic;

import java.util.Arrays;

public class TwoSumII {

    public static void main(String[] args) {
        int [] nums = {2,7,11,13};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums,target)));
    }

    static int [] twoSum (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int sum = 0;

        while (left < right) {
            sum = nums[left] + nums[right];

            if (sum == target) {
                return new int [] {left+1,right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}
