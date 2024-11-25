package OAFacebook;

public class SearchRotatedArray {

    public static void main(String[] args) {
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println(searchRotatedArray(nums,target));
    }

    static int searchRotatedArray (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if (nums[left] == target) {
                return left;
            } if (nums[right] == target) {
                return right;
            } else if (nums[left] < target && nums[right] > target) {
                int mid = (left + right)/2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid -1;
                } else {
                    return mid;
                }
            } else if (nums[left] < target) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return -1;
    }
}
