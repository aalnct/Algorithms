package restart.string.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        String text1 = "SILENT";
        String text2 = "LISTEN";

        System.out.println(isAnagram(text1,text2));
    }

    static boolean isAnagram (String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }

        Map<Character,Integer> map = new HashMap<>();

        for (char c : text1.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        // traverse 2 to decrease count
        for (char c : text2.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) -1);
            if (map.get(c) == 0) {
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}