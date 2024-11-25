package OAGoogle.binarysearch;

public class RotatedSortedArray {

    public static void main(String[] args) {
        int [] array = {4,5,6,7,0,1,2};
        int target = 2; // output should be 4
        System.out.println(search(array,target));
    }

    private static int search(int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            } else if (nums[left] < target && nums[right] > target) {
                // then we need mid ...
                int mid = (left + right) / 2;

                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid-1;
                } else {
                    return mid;
                }
            } else if (nums[left] < target ) {
                // right = right - 1;
                left = left + 1;
            } else {
                // left = left + 1;
                right = right -1 ;
            }
        }
        return -1;
    }


}
