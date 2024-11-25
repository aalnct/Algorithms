package OAFacebook;

public class PeakElement {

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(findPeakElement(nums));
        System.out.println(findPeakElement_2(nums));
    }

    static int findPeakElement (int [] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i=1; i < nums.length-1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                result = i;
            }
        }

        return result;
    }

    static int findPeakElement_2 (int [] nums) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = left + (right - left)/2;

            if (nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
