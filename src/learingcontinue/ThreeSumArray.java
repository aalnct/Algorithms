package learingcontinue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumArray {

    public static void main(String[] args) {
        int [] array = {5,6,1,6,9, 8, 4};
        int target = 19;

        List<List<Integer>> result = find3Sum(array,target);
        result.forEach(sublist -> System.out.println(sublist));

        array  = new int[] {-2,0,0,2,2};
        result = theeSumEqualsZero(array);
        result.forEach(sublist -> System.out.println("three sum for zero :: " + sublist));

        array  = new int[] {-2,0,0,2,2};
        result = threeSum(array);
        result.forEach(sublist -> System.out.println("three sum  :: " + sublist));

    }

    private static List<List<Integer>> find3Sum (int [] array, int target) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(array);

        for (int i=0; i < array.length; i++) {
            int j = i+1;
            int k = array.length-1;

            while (j < k) {
                int sum  = array[i] + array[j] + array[k];
                if (sum == target) {
                    if (!list.contains(Arrays.asList(array[i], array[j], array[k]))) {
                        list.add(Arrays.asList(array[i], array[j], array[k]));
                    }
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return list;
    }

    // time complexity for this is O(n2)
    private static List<List<Integer>> theeSumEqualsZero (int [] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);



        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicate elements
            }
            int j = i+1;
            int k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    if (!list.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }

    private static List<List<Integer>> threeSum(int [] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); //-2,0,0,2,2

        int i = 0;
        int j = i+1;
        int k = nums.length-1;

        while (i < k) {
            while (j < k && nums[i] + nums[j] >0) {
                j++;
            }
            while (k > j && nums[i] + nums[k] < 0) {
                k--;
            }
            if (j < k && nums[i] + nums[j]+nums[k] == 0) {
                if (!list.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
            i++;
        }
        return list;
    }
}
