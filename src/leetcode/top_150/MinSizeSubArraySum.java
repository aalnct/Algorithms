package leetcode.top_150;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int [] nums = {2,3,1,2,4,3};
        int target = 7;

        System.out.println(minSizeSubArraySum(nums, target));
    }

    private static int minSizeSubArraySum (int [] nums, int target) {
        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right =0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
