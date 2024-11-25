package restart.array.basic;

import java.util.Arrays;

public class ReturnNonDuplicate {

    public static void main(String[] args) {
        int [] nums = {1,1,2,2,3}; // return 3
        System.out.println(Arrays.toString(returnNonDuplicate(nums)));
    }

    static int [] returnNonDuplicate(int [] nums) {
        Arrays.sort(nums); // O(nlogn)
        int k = 0;
        for (int i=0; i < nums.length; i++) {
            if (
                    (i == 0 || nums[i] != nums[i-1])
                    &&
                            (i == nums.length-1 || nums[i] != nums[i+1])
            ) {
                nums[k++] = nums[i];
            }
        }
        return Arrays.copyOf(nums,k);
        // throw new IllegalArgumentException("No non-duplicate element");
    }
}
