package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int [] array = {-1, 0, 1, 2, -3, 4, 5};
        int target = 0;

        List<List<Integer>> result = threeSum(array,target);
        System.out.println(result);


        result = threeSumImprovePerformance(array,target);
        System.out.println(result);


        result = threeSumSlidingWindow(array,target);
        System.out.println(result);

    }


    public static List<List<Integer>> threeSum (int[] array, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(array);
        for (int i=0; i < array.length; i++) {
            int left = i+1;
            int right = array.length-1;

            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];

                if (currentSum == target) {
                    if (!triplets.contains(Arrays.asList(array[i], array[left], array[right]))) {
                        triplets.add(Arrays.asList(array[i], array[left], array[right]));
                    }
                    left++;
                    right--;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }


    private static List<List<Integer>> threeSumImprovePerformance(int [] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> triplets = new ArrayList<>();

        for (int i=0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == target) {
                    if (!triplets.contains(Arrays.asList(nums[i], nums[left], nums[right]))) {
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                }
                else if (currentSum < target) {
                    while (left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                        left++;
                    } else {
                    while (left < right && nums[right] == nums[right-1]) {
                        right--;
                    }
                        right--;
                    }

            }
        }
        return triplets;
    }

    // time complexity -- O(N) using sliding window apporach
    private static List<List<Integer>> threeSumSlidingWindow(int [] array, int target) {
        List<List<Integer>> triplets = new ArrayList<>();
        int windowStart = 0;
        int windowEnd = 2;

        while (windowEnd < array.length && windowStart < windowEnd-1) {
            int currentSum = array[windowStart] + array[windowEnd] + array[windowStart+1];
            if (currentSum == target) {
                triplets.add(Arrays.asList(array[windowStart], array[windowStart+1], array[windowEnd]));
                windowStart++;
                windowEnd++;
            } else if (currentSum < target) {
                windowEnd++;
            } else {
                if (windowStart+1 == windowEnd) {
                    windowEnd++;
                } else {
                    windowStart++;
                }
            }
        }
        return triplets;
    }
}
