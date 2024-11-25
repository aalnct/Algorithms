package leetcode.top_150;

public class FindPeakElement {

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement (int [] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
