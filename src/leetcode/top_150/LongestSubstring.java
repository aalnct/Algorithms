package leetcode.top_150;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest substring without repeating characters
 */
public class LongestSubstring {

    public static void main(String[] args) {
        String text = "abcabcbb";
        System.out.println(longestSubString(text));
    }

    private static int longestSubString (String text) {
        int end = 0;
        int start = 0;
        int maxLength = 0;
        int n = text.length();

        Set<Character> set = new HashSet<>();

        while (end < n) {
            char currentChar = text.charAt(end);
            if (!set.contains(currentChar)) {
                set.add(currentChar);
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else {
                set.remove(text.charAt(start));
                start++;
            }
        }
        return maxLength;
    }
}
