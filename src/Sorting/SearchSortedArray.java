package Sorting;

public class SearchSortedArray {

    public static void main(String[] args) {
        int [] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        System.out.println(searchSortedArray(nums, target));
        System.out.println(searchSortedArray_2(nums, target));

        System.out.println(searchInSotedArray_3(nums, target));
    }

    // we will use the approach of binary search
    private static int searchSortedArray(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            if (nums[left] == target) {
                return left;
            } else if (nums[right] == target) {
                return right;
            } else if (nums[left] < target && nums[right] > target) {
                int mid = (left + right) / 2; // get the mid, so that we can use the binary tree concept, and our search can be divided in half
                if (nums[mid] < target) {
                    left = mid + 1;
                } else{
                    right = mid - 1;
                }
            } else if (nums[left] < target ) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return -1;
    }

    // array may contain duplicates

    private static boolean searchSortedArray_2(int [] nums, int target) {
        // we are using the modified binary search
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            if (nums[left] == target) {
                return true;
            } else if (nums[right] == target) {
                return true;
            } else if (nums[left] < target && nums[right] > target) {
                // calculate mid now to know where to move
                int mid = (left + right)/2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                }
            } else if (nums[left] < target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }
        return false;
    }

    private static boolean searchInSotedArray_3(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            if (nums[left] == target) {
                return true;
            } else if (nums[right] == target) {
                return true;
            }

            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[right] == nums[mid]) {
                right--;
            } else if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else if (target > nums[mid] && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid-1;
            }

        }
        return false;
    }
}
