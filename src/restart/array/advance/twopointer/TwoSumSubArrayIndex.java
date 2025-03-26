package restart.array.advance.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumSubArrayIndex {

    public static void main(String[] args) {
        int [] array = {1,2,3,7,5};
        System.out.println(subArraySumIndexes(array,12));
    }

    static ArrayList<Integer> subArraySumIndexes (int [] array, int target) {
        // two pointer approach
        // both right and left start from left most point
        // shrink window when current sum > target
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int currentSum = array[0];
        int n = array.length;

        for (int right = 1; right <= n; right++) {
            while (currentSum > target && left < right-1) {
                currentSum -=array[left];
                left++;
            }

            if (currentSum == target) {
                list.add(left+1);
                list.add(right);
                return list;
            }

            if (right < n) {
                currentSum += array[right];
            }
        }
        list.add(-1);
        return list;
    }
}
