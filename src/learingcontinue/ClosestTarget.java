package learingcontinue;

import java.util.*;

public class ClosestTarget {

    public static void main(String[] args) {
        int [] nums = {4,5,9,2,1};
        int target = 12;

        // closestTarget(nums,target).forEach(System.out::println);

        findClosestTarget(nums,target).forEach(System.out::println);


        nums = new int [] { -1, 2, 1, -4 };
        target = 1;
        int closestSum = findTriplet(nums, target);
        System.out.println("Closest sum to the target: " + closestSum);
    }

    // incorrect approach
    static List<Integer> closestTarget (int [] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        Map<List<Integer>, Integer> closest = new HashMap<>();
        List<Integer> list = null;
        // take the sum of each number, then store the value as key, and result as value ?

        while (left < right) {
            list = new ArrayList<>();
            int sum = nums[left] + nums [right] ;
            list.add(nums[left]);
            list.add(nums[right]);

            closest.put(list, sum);

            left++;
            right--;
        }

        int minValue = Collections.min(closest.values());

        for (Map.Entry<List<Integer>, Integer> entry : closest.entrySet()) {
            if (Objects.equals(minValue, entry.getValue())) {
                return entry.getKey();
            }
        }

        return list;
    }

    static List<Integer> findClosestTarget (int [] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        int minDifference = Integer.MAX_VALUE;
        List<Integer> pair = new ArrayList<>();


        while (left < right) {
            int sum = nums[left] + nums[right];
            int difference = target - sum;

            if (Math.abs(difference) < Math.abs(minDifference)) {
                minDifference = difference;
                pair.clear();
                pair.add(nums[left]);
                pair.add(nums[right]);
            }

            if (difference < 0){
                right--;
            } else if (difference > 0) {
                left++;
            } else {
                return pair;
            }
        }

        return pair;
    }

    private static int findTriplet(int [] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;

        for (int i =0; i < n-2; i++) {
            int left = i+1;
            int right = n-1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left ++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
