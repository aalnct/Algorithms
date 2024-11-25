package OAGoogle.array;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        dutchNationalFlag(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void dutchNationalFlag(int [] nums) {
        int left = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid < high) { // 0 < 5 true
            if (nums[mid] == 0) { // nums[mid] == 0 --> false
                swaps(nums,left,mid);
                left++;
                mid ++;
            } else if (nums[mid] == 1) { // nums[mid] == 1 --> false
                mid++;
            } else {
                swaps(nums,mid,high);
                high--;
            }
        }
    }

    private static void swaps(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
