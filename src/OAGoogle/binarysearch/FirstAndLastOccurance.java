package OAGoogle.binarysearch;

public class FirstAndLastOccurance {

    public static void main(String[] args) {
        int [] nums = {5,6,7,7,8,8,10};
        int target = 8;
        int [] result = searchRange(nums,target);

        for (int r : result) {
            System.out.println(r);
        }
    }

    static int[] searchRange (int [] nums, int target) {
        int firstPositions = findFirstOccurance(nums,target);
        int secondPositions = findSecondOccurance(nums,target);

        return new int [] {firstPositions,secondPositions};
    }

    static int findFirstOccurance(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int result = -1;

        while (left <= right) {
            int pivot = left + (right - left)/2;

            if (nums[pivot] >= target) {
                if (nums[pivot] == target) {
                    result = pivot;
                }
                right = pivot-1;
            } else {
                left = pivot + 1;
            }
        }
        return result;
    }

    static int findSecondOccurance(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;

        while (left <= right) {
            int pivot = left + (right - left)/2;

            if (nums[pivot] <= target) {
                if (nums[pivot] == target) {
                    result = pivot;
                }
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return result;
    }
}
