package restart.gemini.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String word = "abcabcbb";
        System.out.println(length(word));
    }
    
    static int length (String word) {
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < word.length(); right++) {
            char current = word.charAt(right);

            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }

            map.put(current,right);

            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }

}
