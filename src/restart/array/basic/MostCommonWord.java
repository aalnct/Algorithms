package restart.array.basic;

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String [] banned = new String[] {"hit"};

        System.out.println(mostCommonWord(paragraph,banned));
    }

    static String mostCommonWord (String paragraph, String [] banned) {
        int maxCount = 0;
        String  result = null;
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String,Integer> map = new HashMap<>();

        String [] words = paragraph.toLowerCase().split("\\W+");
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int count = map.getOrDefault(word,0)+1;
                map.put(result,count);
                if (count > maxCount) {
                    maxCount = count;
                    result = word;
                }
            }
        }
        return result;
    }
}
