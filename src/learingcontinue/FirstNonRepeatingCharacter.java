package learingcontinue;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String repeatingCharacters = "223387";
        System.out.println(firstNonRepeating(repeatingCharacters));
    }

    private static int firstNonRepeating(String string) {
        if (string == null || string.isEmpty()) {
            return -1;
        }
        Map<Character,Integer> countMap = new HashMap<>();
        for (int i=0; i < string.length(); i++) {
            char c = string.charAt(i);
            new String(String.valueOf(c));
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            if (countMap.get(c) == 1) {
                return i;
            }

        }

        return -1;
    }
}
