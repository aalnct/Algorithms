package restart.array.advance;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int [] nums = {200,1,4,100,2,3};
        System.out.println(longestConsecutiveSequence(nums));
    }


    static int longestConsecutiveSequence (int [] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int longestStreak = 0;

        Set<Integer> numSet = new HashSet<>();

        for (int n : nums) {
            numSet.add(n);
        }

        for (int n : nums) {
            if (!numSet.contains(n-1)) {
                int currentNumber = n;
                int currentStreak = 1;

                while (numSet.contains(currentNumber+1)) {
                    currentNumber++;
                    currentStreak++;
                }

                longestStreak = Math.max(currentStreak,longestStreak);
            }
        }
        return longestStreak;
    }
}