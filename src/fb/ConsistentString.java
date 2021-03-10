package fb;

import java.util.HashSet;
import java.util.Set;

public class ConsistentString {

    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentString(allowed,words));
    }

    static int countConsistentString(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int counter = words.length;

        for (int i=0;i < allowed.length();i++) {
            set.add(allowed.charAt(i)); // will prevent duplicate
        }

        for (String str : words) {
            for (int i=0;i<str.length();i++) {
                if (!set.contains(str.charAt(i))) {
                    counter--;
                    break;
                }
            }
        }
        return counter;
    }
}
