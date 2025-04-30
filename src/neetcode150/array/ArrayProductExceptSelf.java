package neetcode150.array;

import java.util.Arrays;

public class ArrayProductExceptSelf {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(Arrays.toString(arrayProductExceptSelf(nums)));
        System.out.println(Arrays.toString(arrayProductButSelf(nums)));
    }

    static int [] arrayProductExceptSelf (int [] nums) {
        int n = nums.length;

        int [] output = new int[n];

        int leftProduct = 1;
        int rightProduct = 1;

        Arrays.fill(output,1);

        for (int i=0; i < n; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = n-1; i >=0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    static int [] arrayProductButSelf(int [] numbers) {
        int n = numbers.length;
        int [] result = new int [n];

        for (int i=0; i < n; i++) {
            int product = 1;
            for (int j=0; j < n; j++) {
                if (i != j) {
                    product *= numbers[j];
                }
            }
            result [i] = product;
        }
        return result;
    }
}
