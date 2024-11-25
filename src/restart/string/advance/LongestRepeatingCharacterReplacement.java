package restart.string.advance;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String text = "ABABBA";
        System.out.println(longestRepeatingCharacterLength(text,2));
    }

    static int longestRepeatingCharacterLength (String text, int k) {
        // k -- the maximum time char in a string can be replaced

        if (text == null || text.length() == 0) {
            return 0;
        }

        int leftCounter = 0;
        int maxLength = 0;

        int maxCount = 0; // keep count of character with max count

        Map<Character,Integer> charCount = new HashMap<>();

        for (int rightCounter = 0; rightCounter < text.length(); rightCounter++) {
            char currentChar = text.charAt(rightCounter);
            charCount.put(currentChar, charCount.getOrDefault(currentChar,0) + 1);
            // keeping track of max count
            maxCount = Math.max(maxCount, charCount.get(currentChar));

            // window size is right - left + 1
            // number of characters to be replaced are window size  - maxCount;
            // if the number of character to be replaced are greater than k, we need to shrink the window size from left ...
            if ((rightCounter - leftCounter + 1) - maxCount > k) {
                // as stated above shrink from left ...
                char leftChar = text.charAt(leftCounter);
                charCount.put(leftChar, charCount.get(leftChar) -1 );
                leftCounter++;
            }

            maxLength = Math.max(maxLength, rightCounter - leftCounter + 1);
        }

        return maxLength;
    }
}
