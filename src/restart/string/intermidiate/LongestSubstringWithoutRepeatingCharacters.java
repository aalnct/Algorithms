package restart.string.intermidiate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String word = "clementisacap";
        System.out.println(longestSubStringWithoutDuplicate(word));
    }

    static int longestSubStringWithoutDuplicate (String word) {
        if (word == null || word.length() == 0) {
            return 0;
        }

        Map<Character,Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < word.length(); right++) {
            char current = word.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1); // just moving left pointer one step a head
            }

            map.put(current,right);

            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
}
