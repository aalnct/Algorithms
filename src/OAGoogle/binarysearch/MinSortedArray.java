package OAGoogle.binarysearch;

public class MinSortedArray {

    public static void main(String[] args) {
        int nums [] = {2, 2, 2, 0, 1, 2};// {3,4,4,0,2,2};
        System.out.println(minSortedArray(nums));
    }

    static int minSortedArray( int [] nums ) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
