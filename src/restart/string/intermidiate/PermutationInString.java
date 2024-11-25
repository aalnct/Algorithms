package restart.string.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(permuationInString(s1,s2));
    }

    private static boolean permuationInString (String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>();
        Map<Character,Integer> s2Map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c,0)+1);
        }

        int windowSize = s1.length(); // since we need this to slide and remove old and add new character

        // populate frequency map for the first window in S2
        for (int i=0; i < windowSize; i++) { // only till first window size
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c, 0)+1);
        }

        // compare both maps
        if (s1Map.equals(s2Map)) {
            return true;
        }

        // else continue to slide window by removing old char and adding new character
        for (int i = windowSize; i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i-windowSize);

            // first add new character in map
            s2Map.put(newChar, s2Map.getOrDefault(newChar,0) + 1);

            // remove old
            if (s2Map.get(oldChar) == 1) {
                s2Map.remove(oldChar);
            } else {
                // start reducing its count
                s2Map.put(oldChar, s2Map.get(oldChar)-1);
            }

            // again compare the maps to check if they are equals
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}
