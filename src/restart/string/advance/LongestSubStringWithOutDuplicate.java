package restart.string.advance;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutDuplicate {

    public static void main(String[] args) {
        String string = "clementisacap";
        System.out.println(longestSubString(string));
    }

    static String longestSubString (String string) {
        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0; // max length of sub string without duplicate character
        int maxStart = 0; // to keep track from where window will start

        for (int i=0; i < string.length(); i++ ) {
            char current = string.charAt(i);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current)+1);
            }
            map.put(current,i);

            // update window now
            if (i-left+1 > maxLength) {
                maxLength = i-left+1; // this is max length of non-duplicate substring
                maxStart = left; // this left gets updated when there is a duplicate encountered
                                // means it shift the window
            }
        }

        return string.substring(maxStart, maxLength + maxStart);
    }
}
