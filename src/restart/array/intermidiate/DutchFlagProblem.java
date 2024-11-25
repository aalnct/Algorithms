package restart.array.intermidiate;

import java.util.Arrays;

public class DutchFlagProblem {

    public static void main(String[] args) {
        int [] nums = {0,1,2,2,0};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int [] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while (mid <= high) {
            // three way partitioning
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }

}
