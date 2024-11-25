package OAGoogle.binarysearch;

public class MinSortedArrayDuplicate {


    public static void main(String[] args) {
        int [] nums = {2,2,2,0,1,2};
        System.out.println(findMinSortedArrayDuplicate(nums));
    }

    static int findMinSortedArrayDuplicate (int [] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right = right - 1; // handle duplicate ...
            }
        }
        return nums[left];
    }
}
