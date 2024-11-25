package leetcode.binarysearch;

import java.util.Arrays;

public class SmallestDistancePair {

    public static void main(String[] args) {
        int [] nums = {1,3,1};
        int k = 1;

        System.out.println(findSmallestDistancePair(nums,k));
    }

    private static int findSmallestDistancePair(int [] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length-1] - nums[0];

        while (left < right) {
            int mid = left + (right - left)/2;
            int count = countPairs(nums, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int countPairs(int[] nums, int midPoint) {
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right ]- nums[left] > midPoint) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}
