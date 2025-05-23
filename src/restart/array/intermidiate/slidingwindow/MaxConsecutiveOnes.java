package restart.array.intermidiate.slidingwindow;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(maxConsecutiveOnes(nums,2));
    }

    static int maxConsecutiveOnes (int [] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        // sliding window approach

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}
