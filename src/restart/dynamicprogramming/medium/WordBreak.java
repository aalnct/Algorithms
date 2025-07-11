package restart.dynamicprogramming.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {

    }

    /**
     *   first solving this problem using Brute Force
     */

    static boolean wordBreakMatches (String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return canBreak(s,0,wordSet);
    }

    static boolean canBreak (String s, int start, Set<String> wordSet) {
        if (start == s.length()) {
            return true;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word  = s.substring(start,end);

            if (wordSet.contains(word) && canBreak(s,end, wordSet)) {
                return true;
            }
        }
        return false;
    }
}
