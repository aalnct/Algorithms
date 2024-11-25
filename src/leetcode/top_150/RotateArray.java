package leetcode.top_150;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int [] nums = {-1};
        int k = 2;

        System.out.println(Arrays.toString(rotateArray(nums,k)));

        nums  = new int [] {-1};
        rotateArray_2(nums,k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int [] rotateArray (int [] nums, int k) {
        int [] temp = new int[nums.length];

        for(int i=0; i < nums.length; i++) {
            temp[ (i+k) % nums.length ] = nums[i];
        }

        for(int i=0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }

    private static void rotateArray_2(int [] nums, int k) {
        int n = nums.length;

        if(n < 2 || k % n == 0) {
            return;
        }

        k = k % n;

        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k, n-1);


    }

    private static void reverse(int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
