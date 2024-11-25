package restart.array.intermidiate;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String word1 = "SILENT";
        String word2 = "LISTED";

        System.out.println(isValidAnagram(word1,word2));
    }

    static boolean isValidAnagram (String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 != len2) {
           return false;
        }

        Map<Character,Integer> anagram = new HashMap<>();

        for (char c : word1.toCharArray()) {
            anagram.put(c, anagram.getOrDefault(c,0)+1); // write word 1 to map
        }

        for (char c : word2.toCharArray()) {
            if (!anagram.containsKey(c)) {
                return false;
            }
            anagram.put(c, anagram.get(c)-1);

            if (anagram.get(c) == 0) {
                anagram.remove(c);
            }
        }
        return true;
    }
}
