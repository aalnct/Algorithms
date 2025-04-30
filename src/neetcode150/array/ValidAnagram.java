package neetcode150.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "carrace";
        String t = "racecar";

        System.out.println(validAnagram(s,t));
        System.out.println(validAnagramOptimizedApproach(s,t));
    }

    // O(n log (n))
    static boolean validAnagram (String s, String t) {

        int lenS = s.length();
        int lenT = t.length();

        if (lenT != lenS) {
            return false;
        }

        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);


        for (int i=0;i < sChar.length; i++) {
            if (sChar[i] != tChar[i]) {
                return false;
            }
        }
        return true;
    }

    // O(N) for time complexity
    // O(K) for space complexity since we have k unique elements in Map
    static boolean validAnagramOptimizedApproach (String s, String t) {

        Map<Character,Integer> frequency = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c,0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!frequency.containsKey(c)) {
                return false;
            }
            frequency.put(c, frequency.get(c)-1);

            if (frequency.get(c) == 0) {
                frequency.remove(c);
            }
        }
        return true;
    }
}
