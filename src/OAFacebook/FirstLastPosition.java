package OAFacebook;

import java.util.Arrays;

public class FirstLastPosition {

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        int target = 8;

        System.out.println(Arrays.toString(firstAndLastPosition(nums,target)));

        int [] result = firstAndLastPosition(nums,target);

        for (int r : result) {
            if (r != 0) {
                System.out.print(r + ",");
            }
        }

        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    // below is brute force approach .. with the worst time complexity of O(n) in case we
    // have to iterate over the entire array ...
    static int [] firstAndLastPosition (int [] nums, int target) {
        int [] result = new int[nums.length];

        for (int i =0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[i] = i;
            }
        }
        return result;
    }

    // now we will try binary search apprach by
    // dividing the array into two parts ...

    static int[] searchRange (int [] nums, int target) {
        int firstOccurance = firstOccurance(nums,target);
        int secondOccurance = secondOccurance(nums,target);

        return new int[] {firstOccurance,secondOccurance};
    }

    static int firstOccurance (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while (left <= right) {
            int pivot = left + (right - left)/2;

            if (nums[pivot] >= target) {
                if (nums[pivot] == target) {
                    result = pivot;
                }
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return result;
    }

    static int secondOccurance (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while (left <= right) {
            int pivot  = left + (right - left)/2;

            if (nums[pivot] <= target) {
                if (nums[pivot] == target) {
                    result = pivot;
                }
                left = pivot + 1;
            } else {
                right = pivot -1;
            }
        }
        return result;
    }
}
