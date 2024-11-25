package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int [] nums = {1,0,-1,0,-2,2};
        // output should be :: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        int target = 0;

        System.out.println(fourSum(nums,target));

        int array [] = {1000000000,1000000000,1000000000,1000000000};
        target = -294967296;
        System.out.println(fourSum_2(array,target));
    }

    private static List<List<Integer>> fourSum (int [] nums, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        // four nested loops

        for (int i=0; i < n-3; i++) {

            for (int j = i+1; j < n-2; j++) {

                for (int k = j + 1; k < n-1; k++) {

                    // apply two pointer to find the fourth element
                    int targetDiff = target - nums[i] - nums[j] - nums[k];
                    int left = k + 1;
                    int right = n-1;

                    while (left < right) {
                        int sum = nums[left] + nums[right];
                        if (sum == targetDiff) {
                            fourSumList.add(
                                    Arrays.asList(nums[i], nums[j], nums[k], nums[left])
                            );
                            left++;
                            right--;
                        } else if (sum < targetDiff) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
        }
        return fourSumList;
    }

    // without using the third loop
    private static List<List<Integer>> fourSum_2 (int [] nums, int target) {
        List<List<Integer>> fourSumList = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i=0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                int left = j+1;
                int right = n-1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        if (!fourSumList.contains(Arrays.asList(nums[i], nums[j] , nums[left] , nums[right]))) {
                            fourSumList.add(
                                    Arrays.asList(nums[i], nums[j] , nums[left] , nums[right])
                            );
                        }
                        left++;
                        right--;

                        // skip duplicate
                        while (left < right && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right+1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return fourSumList;
    }
}
