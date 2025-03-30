package neetcode150.twopointer;

import java.util.Arrays;

public class TwoIntegerSumII {

    public static void main(String[] args) {
        int target = 6;
        int [] numbers = {2,3,4};

        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }

    static int [] twoSum (int [] numbers, int target) {

        int left = 0;
        int right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int [] {left+1, right+1};
            } else if (sum < target ) {
                left++;
            } else {
                right--;
            }
        }
        return new int [] {};
    }
}
