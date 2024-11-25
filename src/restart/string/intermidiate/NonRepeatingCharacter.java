package restart.string.intermidiate;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {

    public static void main(String[] args) {
        String text = "swiss";
        System.out.println(nonRepeatingCharacter(text));
    }

    static char nonRepeatingCharacter (String text) {
        Map<Character,Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for (char c : text.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '0'; // no non-repeating character found
    }

}
