package leetcode.binarysearch;

import java.util.Arrays;

public class TwoSumArray {

    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(findTwoSum(nums, target)));
    }

    private static int [] findTwoSum(int [] nums, int target) {
        int [] result = new int[2];
        int left = 0;
        int right = nums.length-1;

        Arrays.sort(nums);

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result[0] = nums[left];
                result[1] = nums[right];

                return result;
            }
            else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1,-1};
    }
}
