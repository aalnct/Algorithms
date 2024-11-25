package OAFacebook;

import java.util.Arrays;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    static int[] productExceptSelf (int [] nums) {
        int n = nums.length;
        int [] left = new int[n];
        int [] right = new int[n];
        int [] result = new int[n];

        int leftProduct = 1;
        int rightProduct = 1;


        // populate left array
        for (int i =0; i < n; i++) {
            left[i] =leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = n-1; i >=0; i--) {
            right[i] = rightProduct;
            rightProduct *= nums[i];
        }

        for (int i=0; i < n ; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }
}
