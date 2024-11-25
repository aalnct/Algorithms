package leetcode.top_150;

import java.util.Arrays;

public class TwoSumArray {
    public static void main(String[] args) {
        int [] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums,target)));

        System.out.println(Arrays.toString(binarySearchTwoSum(nums,target)));
    }

    private static int [] twoSum(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        int [] resultArray = new int[2];

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(target == sum) {
                resultArray[0] = ++left;
                resultArray[1] = ++right;

                return resultArray;

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int [] {-1, -1};
    }


    /**
     * Binary Search approach with t(n) is O(n log n)
     */
    private static int [] binarySearchTwoSum(int [] nums, int target) {
        for (int i=0; i < nums.length; i++) {
            int complement = target - nums[i];
            int index = binarySearch(nums, complement, i+1, nums.length-1);
            if(index != -1) {
                return new int [] {i+1, index + 1};
            }
        }
        return new int[0];
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}
