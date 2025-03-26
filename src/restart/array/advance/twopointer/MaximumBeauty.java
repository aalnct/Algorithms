package restart.array.advance.twopointer;

import java.util.Arrays;

public class MaximumBeauty {

    public static void main(String[] args) {
        int [] nums = {4,6,1,2};
        System.out.println(maximumBeauty(nums,2));
    }

    static int maximumBeauty (int [] nums, int k) {
        Arrays.sort(nums);

        int left = 0;
        int maxBeauty = 0;

        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }

            maxBeauty = Math.max(maxBeauty, right - left + 1);

        }
        return maxBeauty;
    }

}
