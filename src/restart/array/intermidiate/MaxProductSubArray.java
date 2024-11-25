package restart.array.intermidiate;

public class MaxProductSubArray {

    public static void main(String[] args) {
        int [] nums = {3 ,12 ,15 ,23, 33, -35, 30, -40, -30, -30, -30, 26, 28};
        System.out.println(maxProductSubArray(nums));

        System.out.println(maxProductSubArray_2(nums));
    }

    static int maxProductSubArray (int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i=1; i <nums.length; i++) {
            int current = nums[i];

            int tempMax = Math.max(current, Math.max(current * maxProduct, current * minProduct));
            minProduct = Math.min(current, Math.min(current * maxProduct, current * minProduct));

            maxProduct = tempMax;

            result = Math.max(result,maxProduct);
        }
        return result;
    }

    static long maxProductSubArray_2 (int [] nums) {
        long maxProduct = nums[0];
        long minProduct = nums[0];
        long result = nums[0];

        for (int i=1; i < nums.length; i++) {
            int current = nums[i];

            if (current < 0) {
                long temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(current, current * maxProduct);
            minProduct = Math.min(current,current * minProduct);

            result = Math.max(result,maxProduct);
        }
        return result;
    }
}
