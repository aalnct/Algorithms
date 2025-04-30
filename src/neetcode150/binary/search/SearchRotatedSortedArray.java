package neetcode150.binary.search;

public class SearchRotatedSortedArray {

    public static void main(String[] args) {
        int [] nums = {3,4,5,6,1,2};
        int target = 1;

        System.out.println(searchRotatedSortedArray(nums,target));
    }

    static int searchRotatedSortedArray (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid  = left + (right - left) /2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) {
                // checking if left side is sorted ...

                if (nums[left] <= target && target < nums[mid]) {
                    // move to left
                    right = mid -1;
                } else {
                    left = mid + 1;
                }

            } else {
                // right half is sorted ...
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1 ;
                }
            }
        }
        return -1;
    }
}
