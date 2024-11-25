package leetcode.top_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = sumArray(nums);

        result.forEach(list -> {
            list.forEach(item -> System.out.print(item + " "));
            System.out.println();
        });
    }

    private static List<List<Integer>> sumArray(int [] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;

            while(left < right) {
                int sum  = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    if (!triplets.contains(Arrays.asList(
                            nums[i], nums[left], nums[right]
                    ))) {
                        triplets.add(Arrays.asList(
                                nums[i], nums[left], nums[right]));
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return triplets;
    }
}
