package neetcode150.binary.search;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = {4,5,0,1,2,3};
        System.out.println(findMinRotatedArray(nums));
    }

    static int findMinRotatedArray (int [] nums) {
        int left = 0;
        int right = nums.length-1;

        if (nums[left] < nums[right] || nums.length==1) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left)/2;

            // if num at mid is greater than num at mid + 1, return nums[mid+1]
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid+1];
            }

            // if num at mid is less than num at left, return nums[mid]
            if (mid > 0 && nums[mid -1] > nums[mid]) {
                return nums[mid];
            }

            // now if num at left is less than/or equal to num at mid, then minimum is at right
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid -1; // else it is in left
            }
        }
        return nums[left];
    }
}