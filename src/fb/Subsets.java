package fb;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    int k = 0;
    int n = 0;

    public static void main(String[] args) {
        int [] nums = new int [] {1,2,3};
        Subsets subsets = new Subsets();
        List<List<Integer>> result = subsets.subsets(nums);
        // result = subSets(nums);
        result.stream().forEach(System.out::println);
    }

     void backTrack (int i, List<Integer> current, int[] nums) {
        if (current.size() == k) {
            result.add(new ArrayList(current));
            return;
        }

        // recursive case
        for (int j = i; j < n; ++j) {
            // add j to current combination
            current.add(nums[j]);

            // use next integers to complete the combinations
            backTrack(i+1,current,nums);

            //backtrack
            current.remove(current.size()-1);
        }
    }

     List<List<Integer>> subsets (int [] nums) {
        n = nums.length;
        for (k =0; k < n+1;++k) {
            backTrack (0, new ArrayList<>(), nums);
        }
        return result;
    }

    // iterative approach

    static List<List<Integer>> subSets (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        if (nums == null || nums.length == 0) {
            return result;
        }

        int s = 0;
        for (int i : nums) {
            s = result.size();
            for (int j =0 ; j < s; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(i);
                result.add(list);
            }
        }
        return result;
    }
}
