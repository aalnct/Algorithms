package fb;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(solution("A2Le", "2pL1"));
    }

    static boolean solution (String s, String t) {
        Set<Character> inputSet = new HashSet<>();
        Set<Character> outputSet = new HashSet<>();

        if (s.length() != t.length()) {
            return false;
        }

        char[] inputArray = s.toLowerCase().toCharArray();
        char[] outputArray = t.toLowerCase().toCharArray();

        Arrays.sort(inputArray);
        Arrays.sort(outputArray);

        for (int i=0;i<inputArray.length;i++) {
            if (Character.isAlphabetic(inputArray[i])) {
                inputSet.add(inputArray[i]);
            }
        }

        for (int i=0;i<outputArray.length;i++) {
            if(Character.isAlphabetic(outputArray[i])) {
                outputSet.add(outputArray[i]);
            }
        }

        if (!inputSet.containsAll(outputSet)) {
            return false;
        }
        return true;
    }
}
