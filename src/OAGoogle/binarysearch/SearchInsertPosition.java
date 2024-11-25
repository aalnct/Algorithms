package OAGoogle.binarysearch;

public class SearchInsertPosition {

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsertPosition(nums,target));
    }

    static int searchInsertPosition(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int pivot = left + (right - left) /2;

            if (nums[pivot] == target)  {
                return pivot;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        return left;
    }
}
