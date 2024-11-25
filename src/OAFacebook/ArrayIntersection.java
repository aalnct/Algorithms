package OAFacebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {

    public static void main(String[] args) {
        int [] nums = {4,9,5};
        int [] nums2 = {9,4,9,8,4};

        System.out.println(Arrays.toString(arrayIntersection(nums,nums2)));

    }

    static int[] arrayIntersection(int [] nums, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }

        int [] resultArray = new int [resultSet.size()];
        int i = 0;
        for (int n : resultSet) {
            resultArray[i++] = n;
        }

        return resultArray;
    }
}
