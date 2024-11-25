package leetcode.top_150;

import java.util.Arrays;

public class ArrayProduct {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productArray(nums)));
    }

    private static int[] productArray(int [] nums) {
        int length = nums.length;
        int [] left = new int[length];
        int [] right = new int[length];
        int [] result = new int[length];

        int leftProduct = 1;
        int rightProduct = 1;

        // first left product
        for(int i=0; i < length; i++) {
            left[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // right product
        for(int i = length-1; i >= 0; i--) {
            right[i] = rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        for(int i=0; i < length; i++) {
            result [i] = left[i] * right[i];
        }
        return result;
    }
}
