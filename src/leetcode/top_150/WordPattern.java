package leetcode.top_150;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        String pattern = "abba";
        String text = "cat dog dog cat";

        System.out.println(wordPattern(pattern,text));
    }

    private static boolean wordPattern (String pattern, String text) {
        String [] words = text.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }


        Map<Character,String> charToWord = new HashMap<>();
        Map<String,Character> wordToChar = new HashMap<>();

        for (int i=0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word,c);
            }
        }
        return true;
    }
}
