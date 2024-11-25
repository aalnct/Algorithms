package leetcode.stringmanipulation;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        String string = "abcabcbb";
        System.out.println(lengthOfSubString(string));
    }

    private static int lengthOfSubString(String string) {
        int left = 0; // left boundary of the sliding window
        Set<Character> set = new HashSet<>();
        int n = string.length();
        int maxLength = 0;

        for(int right =0; right < n; right++) {
            if(!set.contains(string.charAt(right))) {
                set.add(string.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while(set.contains(string.charAt(right))) {
                    set.remove(string.charAt(left));
                    left++;
                }
                set.add(string.charAt(right));
            }
        }
        return maxLength;
    }
}
