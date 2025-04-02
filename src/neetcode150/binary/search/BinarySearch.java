package neetcode150.binary.search;

public class BinarySearch {

    public static void main(String[] args) {
        int [] nums = {-1,0,2,4,6,8};
        System.out.println(binarySearch(nums,4));
    }

    static int binarySearch (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if (nums[mid] == target) {
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
