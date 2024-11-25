package leetcode.top_150;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(firstAndLastPosition(nums,target)));
    }

    private static int [] firstAndLastPosition (int [] nums, int target) {
        return new int [] {firstPosition(nums, target), secondPosition(nums,target)};
    }

    private static int firstPosition(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while (left <= right) {
            int pivot = left + (right - left)/2;
            if (nums[pivot] >= target) {
                if (nums[pivot] == target) {
                    result = pivot;
                }
                right = pivot -1;
            } else {
                left = pivot + 1;
            }
        }
        return result;
    }

    private static int secondPosition (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while (left <= right) {
            int pivot = left + (right - left)/2;
            if (nums[pivot] <= target) {
                if (nums[pivot] == target) {
                    result =  pivot;
                }
                left = pivot + 1;
            } else {
                right = pivot -1;
            }
        }
        return result;
    }
}