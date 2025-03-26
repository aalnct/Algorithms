package restart.array.basic;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateII {

    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums,3));
    }

    // found duplicate with in range of k
    static boolean containsDuplicate(int [] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else{
                set.add(nums[i]);
            }
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
