package restart.gemini.binarysearch;

public class FindSingleElement {

    public static void main(String[] args) {
        int [] nums = {1,1,2,3,3,4,4};
        System.out.println(findSingleElement(nums));
    }

    static int findSingleElement (int [] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (mid % 2 == 1) {
                mid--; // keep mid as even for comparision
            }

            if (nums[mid] == nums[mid+1]) {
                // means element is on right side since parity is not broken , since mid is even and
                // all duplicate elements are starting at even index

                left = mid+2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
