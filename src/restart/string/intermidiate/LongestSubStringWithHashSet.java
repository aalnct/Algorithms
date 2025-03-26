package restart.string.intermidiate;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithHashSet {

    public static void main(String[] args) {
        String text = "abcabcab";
        System.out.println(longestSubStringLength(text));
    }

    private static int longestSubStringLength(String text) {
        int a_pointer = 0;
        int b_pointer = 0;

        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        while (b_pointer < text.length()) {
            if (!set.contains(text.charAt(b_pointer))) {
                set.add(text.charAt(b_pointer));
                b_pointer++;
                maxLength = Math.max(set.size(),maxLength);
            } else {
                set.remove(text.charAt(a_pointer));
                a_pointer++;
            }
        }
        return maxLength;
    }
}
